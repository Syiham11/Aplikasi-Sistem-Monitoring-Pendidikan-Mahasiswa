package me.intan.mpm.jadwal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import me.intan.mpm.R;



public class JadwalAdapter extends BaseAdapter {
	private final Activity activity;
	private LayoutInflater inflater;
	private final List<JadwalData> jadwalItems;


	public JadwalAdapter(Activity activity, List<JadwalData> jadwalItems) {
		this.activity = activity;
		this.jadwalItems = jadwalItems;
	}

	@Override
	public int getCount() {
		return jadwalItems.size();
	}

	@Override
	public Object getItem(int location) {
		return jadwalItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.jadwal_row, null);



		//String txt = (String) this.getItem(position);

//   Here is what you're looking for:
		((TextView) convertView.findViewById(R.id.tvNo)).setText(""+ (position + 1) + ". ");
//   End






		//TextView no_jadwal = (TextView) convertView.findViewById(R.id.tvNo);
		TextView hari = (TextView) convertView.findViewById(R.id.tvHari);
		TextView tanggal = (TextView) convertView.findViewById(R.id.tvTanggal);
		TextView jam = (TextView) convertView.findViewById(R.id.tvJam);
		TextView sks = (TextView) convertView.findViewById(R.id.tvSks);
		TextView nama_mk = (TextView) convertView.findViewById(R.id.tvMkul);
		TextView nama_dosen = (TextView) convertView.findViewById(R.id.tvDosen);
		TextView ruang = (TextView) convertView.findViewById(R.id.tvRuang);

		// getting khs data for the row
		JadwalData m = jadwalItems.get(position);

        // nama_mk
	//	no_jadwal.setText(m.getno_jadwal());
		//kode_mk
		hari.setText(m.gethari());
		// nama_mk
		tanggal.setText(m.gettanggal());
		// sks
		jam.setText(m.getjam());
    	// grade
		sks.setText(m.getsks());
		// nama_mk
		nama_mk.setText(m.getnama_mk());
		// sks
		nama_dosen.setText(m.getnama_dosen());
		// grade
		ruang.setText(m.getruang());

		return convertView;
	}

}