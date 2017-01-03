package me.intan.mpm.absen;



public class AbsenData {

	private String no_absen, hari, tanggal,makul, keterangan;



	public AbsenData() {
	}

	public AbsenData(String no_absen, String hari, String tanggal, String makul, String keterangan) {
		this.no_absen = no_absen;
		this.hari = hari;
		this.tanggal = tanggal;
		this.makul = makul;
		this.keterangan = keterangan;
	}


	public String getno_absen() {

		return no_absen;
	}
	public void setno_absen(String no_absen) {

		this.no_absen = no_absen;
	}

	public String gethari() {

		return hari;
	}
	public void sethari(String hari) {

		this.hari = hari;
	}

	public String gettanggal() {

		return tanggal;
	}
	public void settanggal(String tanggal) {

		this.tanggal = tanggal;
	}

	public String getmakul() {

		return makul;
	}
	public void setmakul(String makul) {

		this.makul = makul;
	}
	public String getketerangan() {

		return keterangan;
	}
	public void setketerangan(String keterangan) {

		this.keterangan = keterangan;
	}

}
