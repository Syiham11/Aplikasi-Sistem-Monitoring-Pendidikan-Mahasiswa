package me.intan.mpm.khs;

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



public class KhsAdapter extends BaseAdapter {
	private final Activity activity;
	private LayoutInflater inflater;
	private final List<KhsData> khsItems;


	public KhsAdapter(Activity activity, List<KhsData> khsItems) {
		this.activity = activity;
		this.khsItems = khsItems;
	}

	@Override
	public int getCount() {
		return khsItems.size();
	}

	@Override
	public Object getItem(int location) {
		return khsItems.get(location);
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
			convertView = inflater.inflate(R.layout.khs_row, null);


	// auto number
		((TextView) convertView.findViewById(R.id.tvNo)).setText(""+ (position + 1) + ". ");
//   End


		TextView kode_mk = (TextView) convertView.findViewById(R.id.tvKode);
		TextView nama_mk = (TextView) convertView.findViewById(R.id.tvMakul);
		TextView sks = (TextView) convertView.findViewById(R.id.tvSks);
		TextView grade = (TextView) convertView.findViewById(R.id.tvNilai);
		TextView nilaibobot = (TextView) convertView.findViewById(R.id.tvNilaiBobot);
		TextView nbxk = (TextView) convertView.findViewById(R.id.tvnbxk);
		TextView keterangan = (TextView) convertView.findViewById(R.id.tvKet);


		//test
	//	TextView ips = (TextView) convertView.findViewById(R.id.ips);
	//	TextView ipk = (TextView) convertView.findViewById(R.id.ipk);
		//TextView msks = (TextView) convertView.findViewById(R.id.msks);
		//TextView jsks = (TextView) convertView.findViewById(R.id.jsks);



		// getting khs data for the row
		KhsData m = khsItems.get(position);


		//kode_mk
		kode_mk.setText(m.getkode_mk());
		// nama_mk
		nama_mk.setText(m.getnama_mk());
		// sks
		sks.setText(m.getsks());
    	// grade
		grade.setText(m.getnh());
		nilaibobot.setText(m.getnilaibobot());
		nbxk.setText(m.getnbxk());
		keterangan.setText(m.getketerangan());

		//test
	//	ips.setText(m.getips());
	//	ipk.setText(m.getipk());
	//	msks.setText(m.getmaksks());
	//	jsks.setText(m.gettelahambil());
		return convertView;
	}

}