package me.intan.mpm.khs;



public class KhsData {

	private String kode_mk, nama_mk,  sks, nh,nilaibobot, nbxk, keterangan, ips, ipk, maksks, telahambil ;



	public KhsData() {
	}

	public KhsData(String kode_mk, String nama_mk,  String sks, String nh,String nilaibobot,String nbxk, String keterangan, String ips, String ipk, String maksks, String telahambil ) {

		this.kode_mk = kode_mk;
		this.nama_mk = nama_mk;
		this.sks = sks;
		this.nh = nh;
		this.nilaibobot = nilaibobot;
		this.nbxk = nbxk;
		this.keterangan = keterangan;
		this.ips = ips;
		this.ipk = ipk;
		this.maksks = maksks;
		this.telahambil = telahambil;


	}


	public String getkode_mk() {

		return kode_mk;
	}
	public void setkode_mk(String kode_mk) {

		this.kode_mk = kode_mk;
	}

	public String getnama_mk() {

		return nama_mk;
	}
	public void setnama_mk(String nama_mk) {

		this.nama_mk = nama_mk;
	}

	public String getsks() {

		return sks;
	}
	public void setsks(String sks) {

		this.sks = sks;
	}

	//
	public String getnh() {
		return nh;
	}
	public void setnh(String nh) {

		this.nh = nh;
	}

	//
	public String getnilaibobot() {
		return nilaibobot;
	}
	public void setnilaibobot(String nilaibobot) {

		this.nilaibobot = nilaibobot;
	}

	//
	public String getnbxk() {
		return nbxk;
	}
	public void setnbxk(String nbxk) {

		this.nbxk = nbxk;
	}

	//
	public String getketerangan() {
		return keterangan;
	}
	public void setketerangan(String keterangan) {

		this.keterangan = keterangan;
	}


	//
	public String getips() {
		return ips;
	}
	public void setips(String ips) {

		this.ips = ips;
	}

	//
	public String getipk() {
		return ipk;
	}
	public void setipk(String ipk) {

		this.ipk = ipk;
	}

	//
	public String getmaksks() {
		return maksks;
	}
	public void setmaksks(String maksks) {

		this.maksks = maksks;
	}

	//
	public String gettelahambil() {
		return telahambil;
	}
	public void settelahambil(String telahambil) {

		this.telahambil = telahambil;
	}

}
