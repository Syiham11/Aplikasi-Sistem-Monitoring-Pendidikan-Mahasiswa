package me.intan.mpm.jadwal;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.intan.mpm.R;
import me.intan.mpm.helper.SQLiteHandler;
import me.intan.mpm.helper.SessionManager;
import me.intan.mpm.main.Activity_Login;
import me.intan.mpm.main.AppController;

public class MainJadwalActivity extends AppCompatActivity {
	// Log tag
	private static final String TAG = MainJadwalActivity.class.getSimpleName();

	private SQLiteHandler db;
	private SessionManager session;
	private EditText editTextSemester;
	private EditText editTextUnit;


	private ProgressDialog pDialog;
	private final List<JadwalData> jadwalList = new ArrayList<>();
	private JadwalAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_jadwal);



		editTextSemester = (EditText) findViewById(R.id.editTextSemester);
		editTextUnit = (EditText) findViewById(R.id.editTextUnit);

		Button btnGet = (Button) findViewById(R.id.buttonGet);

		final ListView listView = (ListView) findViewById(R.id.listview);
		adapter = new JadwalAdapter(this, jadwalList);

				listView.setAdapter(adapter);

		pDialog = new ProgressDialog(this);



		// make request
		btnGet.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				String smt = editTextSemester.getText().toString().trim();
				if (smt.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Semester Kosong", Toast.LENGTH_LONG)
							.show();
					return;
				}

				String unt = editTextUnit.getText().toString().trim();
				if (unt.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Unit Kosong", Toast.LENGTH_LONG)
							.show();
					return;
				}

				pDialog.setMessage("Loading...");
				pDialog.show();

				db = new SQLiteHandler(getApplicationContext());

				// session manager
				session = new SessionManager(getApplicationContext());

				if (!session.isLoggedIn()) {
					logoutUser();
				}

				HashMap<String, String> user = db.getUserDetails();


				String nim = user.get("nim");

				// Creating volley request obj

				String uri = "http://10.0.2.2/server/api/jadwal.php?id="+nim+"&unt="+unt+"&smt="+smt;
				//String uri = "http://10.0.2.2/server/api/jadwal.php?id="+nim;
				JsonArrayRequest khsReq = new JsonArrayRequest(uri,new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						Log.d(TAG, response.toString());
						hideDialog();
						jadwalList.clear();

						// Parsing json
						for (int i = 0; i < response.length(); i++) {
							try {


								JSONObject obj = response.getJSONObject(i);
								JadwalData jadwal = new JadwalData();
							//	jadwal.setno_jadwal(obj.getString("id"));
								jadwal.sethari(obj.getString("hari"));
								jadwal.settanggal(obj.getString("tanggal"));
								jadwal.setjam(obj.getString("jam"));
								jadwal.setsks(obj.getString("jum_sks"));
								jadwal.setnama_mk(obj.getString("nama_mk"));
								jadwal.setnama_dosen(obj.getString("nama_dosen"));
								jadwal.setruang(obj.getString("ruang"));

								// adding khs to khs array
								jadwalList.add(jadwal);


							} catch (JSONException e) {
								e.printStackTrace();
							}

						}

						// notifying list adapter about data changes
						// so that it renders the list view with updated data
						adapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						VolleyLog.d(TAG, "Error: " + error.getMessage());
						Toast.makeText(getApplicationContext(),
								"Tidak ada data!!", Toast.LENGTH_LONG)
								.show();

						jadwalList.clear();
						adapter.notifyDataSetChanged();
						hideDialog();
					}
				});


				// Adding request to request queue
				AppController.getInstance().addToRequestQueue(khsReq);



			}
		});

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		hideDialog();
	}

	private void hideDialog() {
		if (pDialog.isShowing())
			pDialog.dismiss();
	}
	private void logoutUser() {
		session.setLogin(false);

		db.deleteUsers();

		// Launching the login activity
		Intent intent = new Intent(MainJadwalActivity.this, Activity_Login.class);
		startActivity(intent);
		finish();
	}
}
