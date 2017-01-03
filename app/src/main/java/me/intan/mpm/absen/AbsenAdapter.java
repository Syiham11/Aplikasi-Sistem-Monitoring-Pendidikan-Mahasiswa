package me.intan.mpm.absen;

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


public class AbsenAdapter extends BaseAdapter {
	private final Activity activity;
	private LayoutInflater inflater;
	private final List<AbsenData> absenItems;


	public AbsenAdapter(Activity activity, List<AbsenData> absenItems) {
		this.activity = activity;
		this.absenItems = absenItems;
	}

	@Override
	public int getCount() {
		return absenItems.size();
	}

	@Override
	public Object getItem(int location) {
		return absenItems.get(location);
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
			convertView = inflater.inflate(R.layout.absen_row, null);



		//String txt = (String) this.getItem(position);

//   Here is what you're looking for:
		((TextView) convertView.findViewById(R.id.tvNo)).setText(""+ (position + 1) + ". ");
//   End








		//TextView no_absen = (TextView) convertView.findViewById(R.id.tvNo);
		TextView hari = (TextView) convertView.findViewById(R.id.tvHari);
		TextView tanggal = (TextView) convertView.findViewById(R.id.tvTanggal);
		TextView makul = (TextView) convertView.findViewById(R.id.tvMkul);
		TextView keterangan = (TextView) convertView.findViewById(R.id.tvKet);

		// getting khs data for the row
		AbsenData m = absenItems.get(position);

        // nama_mk
		//no_absen.setText(m.getno_absen());
		//kode_mk
		hari.setText(m.gethari());
		// nama_mk
		tanggal.setText(m.gettanggal());
		// sks
		makul.setText(m.getmakul());
    	// grade
		keterangan.setText(m.getketerangan());

		return convertView;
	}

}