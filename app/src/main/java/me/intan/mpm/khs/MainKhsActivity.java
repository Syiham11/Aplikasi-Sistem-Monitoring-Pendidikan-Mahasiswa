package me.intan.mpm.khs;


import me.intan.mpm.helper.SQLiteHandler;
import me.intan.mpm.helper.SessionManager;
import me.intan.mpm.main.Activity_Login;
import me.intan.mpm.main.AppController;
import me.intan.mpm.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

public class MainKhsActivity extends AppCompatActivity {
	// Log tag
	private static final String TAG = MainKhsActivity.class.getSimpleName();

	private SQLiteHandler db;
	private SessionManager session;
	private EditText editTextSemester;
	private EditText editTextUnit;


	private ProgressDialog pDialog;
	private final List<KhsData> khsList = new ArrayList<>();
	private KhsAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_khs);



		editTextSemester = (EditText) findViewById(R.id.editTextSemester);
		editTextUnit = (EditText) findViewById(R.id.editTextUnit);

		Button btnGet = (Button) findViewById(R.id.buttonGet);

		final ListView listView = (ListView) findViewById(R.id.listview);
		adapter = new KhsAdapter(this, khsList);

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

				String uri = "http://10.0.2.2/server/api/nilai.php?id="+nim+"&unt="+unt+"&smt="+smt;
				JsonArrayRequest khsReq = new JsonArrayRequest(uri,new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						Log.d(TAG, response.toString());
						hideDialog();
						khsList.clear();

						// Parsing json
						for (int i = 0; i < response.length(); i++) {
							try {


								JSONObject obj = response.getJSONObject(i);
								KhsData khs = new KhsData();


//test
								((TextView) findViewById(R.id.ips)).setText(obj.getString("ips"));
								((TextView) findViewById(R.id.ipk)).setText(obj.getString("ipk"));
								((TextView) findViewById(R.id.msks)).setText(obj.getString("maksks"));
								((TextView) findViewById(R.id.jsks)).setText(obj.getString("telahambil"));
								// test



								khs.setkode_mk(obj.getString("kode_mk"));
								khs.setnama_mk(obj.getString("nama_mk"));
								khs.setsks(obj.getString("sks"));
								khs.setnh(obj.getString("nh"));
								khs.setnilaibobot(obj.getString("nb"));
								khs.setnbxk(obj.getString("nbxk"));
								khs.setketerangan(obj.getString("ket"));

								//test
								//khs.setips(obj.getString("ips"));
							//	khs.setipk(obj.getString("ipk"));
								//khs.setmaksks(obj.getString("maksks"));
								//khs.settelahambil(obj.getString("telahambil"));
								// adding khs to khs array
								khsList.add(khs);


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

						khsList.clear();
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
		Intent intent = new Intent(MainKhsActivity.this, Activity_Login.class);
		startActivity(intent);
		finish();
	}
}
