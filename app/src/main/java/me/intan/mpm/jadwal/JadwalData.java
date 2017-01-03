package me.intan.mpm.jadwal;



public class JadwalData {

	private String no_jadwal, hari, tanggal,  jam, sks, nama_mk, nama_dosen, ruang;



	public JadwalData() {
	}

	public JadwalData(String no_jadwal, String hari, String tanggal, String jam, String sks,String nama_mk, String nama_dosen, String ruang) {
		this.no_jadwal = no_jadwal;
		this.hari = hari;
		this.tanggal = tanggal;
		this.jam = jam;
		this.sks = sks;
		this.nama_mk = nama_mk;
		this.nama_dosen = nama_dosen;
		this.ruang = ruang;
	}


	public String getno_jadwal() {

		return no_jadwal;
	}
	public void setno_jadwal(String no_jadwal) {

		this.no_jadwal = no_jadwal;
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

	public String getjam() {

		return jam;
	}
	public void setjam(String jam) {

		this.jam = jam;
	}
	public String getsks() {

		return sks;
	}
	public void setsks(String sks) {

		this.sks = sks;
	}
	public String getnama_mk() {

		return nama_mk;
	}
	public void setnama_mk(String nama_mk) {

		this.nama_mk = nama_mk;
	}
	//
	public String getnama_dosen() {

		return nama_dosen;
	}
	public void setnama_dosen(String nama_dosen) {

		this.nama_dosen = nama_dosen;
	}
	//
	public String getruang() {

		return ruang;
	}
	public void setruang(String ruang) {

		this.ruang = ruang;
	}
}
