package me.intan.mpm.transkrip;



public class TransData {

	private String nim, nama, prodi, smt, kode_mk, nama_mk,  sks, n,b, 	sksxb, 	ket, n1, n2, ipk  ;



	public TransData() {
	}

	public TransData(String nim,String nama,String prodi,String smt,String kode_mk, String nama_mk, String sks,String n,String b,String sksxb,String ket,String n1,String n2,String ipk ) {


		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
		this.smt = smt;
		this.kode_mk = kode_mk;
		this.nama_mk = nama_mk;
		this.sks = sks;
		this.n = n;
		this.b = b;
		this.sksxb = sksxb;
		this.ket = ket;
		this.n1 = n1;
		this.n2 = n2;
		this.ipk = ipk;
	}


	public String getnim() {

		return nim;
	}
	public void setnim(String nim) {

		this.nim = nim;
	}

	public String getnama() {

		return nama;
	}
	public void setnama(String nama) {

		this.nama = nama;
	}
	public String getprodi() {

		return prodi;
	}
	public void setprodi(String prodi) {

		this.prodi = prodi;
	}
	public String getsmt() {

		return smt;
	}
	public void setsmt(String smt) {

		this.smt = smt;
	}
	public String getkode_mk() {

		return kode_mk;
	}
	public void setkode_mk(String kode_mk) {

		this.kode_mk = kode_mk;
	}
	//
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
	public String getn() {
		return n;
	}
	public void setn(String n) {

		this.n = n;
	}

	//
	public String getb() {
		return b;
	}
	public void setb(String b) {

		this.b = b;
	}

	//
	public String getsksxb() {
		return sksxb;
	}
	public void setsksxb(String sksxb) {

		this.sksxb = sksxb;
	}

	//
	public String getket() {
		return ket;
	}
	public void setket(String ket) {

		this.ket = ket;
	}


	//
	public String getn1() {
		return n1;
	}
	public void setn1(String n1) {

		this.n1 = n1;
	}
	//
	public String getn2() {
		return n2;
	}
	public void setn2(String n2) {

		this.n2 = n2;
	}
	//
	public String getipk() {
		return ipk;
	}
	public void setipk(String ipk) {

		this.ipk = ipk;
	}

}
