package me.intan.mpm.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;


import me.intan.mpm.absen.MainAbsenActivity;
import me.intan.mpm.helper.SQLiteHandler;
import me.intan.mpm.helper.SessionManager;
import me.intan.mpm.R;
import me.intan.mpm.info.Activity_Akademik_Intro;
import me.intan.mpm.info.Activity_Extrakurikuler_Intro;
import me.intan.mpm.info.Activity_Universitas_Intro;
import me.intan.mpm.info.AkademikActivity;
import me.intan.mpm.info.ExtrakurikulerActivity;
import me.intan.mpm.info.UniversitasActivity;
import me.intan.mpm.jadwal.MainJadwalActivity;
import me.intan.mpm.khs.MainKhsActivity;
import me.intan.mpm.transkrip.MainTransActivity;

public class Activity_Main extends AppCompatActivity {
    private SQLiteHandler db;
    private SessionManager session;
    // ------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // setTitle("Main Menu");

        TextView txtName = (TextView) findViewById(R.id.name);
      //  txtEmail = (TextView) findViewById(R.id.email);
        Button btnLogout = (Button) findViewById(R.id.btnLogout);

        //--------------------
        Button btnUniversitas = (Button) findViewById(R.id.btnUniversitas);
        Button btnAkademik = (Button) findViewById(R.id.btnAkademik);
        Button btnExtrakurikuler = (Button) findViewById(R.id.btnExtrakurikuler);
        Button btnJadwal = (Button) findViewById(R.id.btnJadwal);
        Button btnNilai = (Button) findViewById(R.id.btnNilai);
        Button btnTrans = (Button) findViewById(R.id.btnTraskrip);
        Button btnAbsen = (Button) findViewById(R.id.btnAbsen);
        Button btnPetunjuk = (Button) findViewById(R.id.btnPetunjuk);
        //------------------------

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from SQLite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        //String email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(name);
      //  txtEmail.setText(email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });


        //-------------------------------------------------------------------------
        // Universitas button click event
        btnUniversitas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bUniversitas();
            }
        });

        // Akademik button click event
        btnAkademik.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bAkademik();
            }
        });
        // Extrakurikuler button click event
        btnExtrakurikuler.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bExtrakurikuler();
            }
        });
        // Jadwal button click event
        btnJadwal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bJadwal();
            }
        });

        // Nilai button click event
        btnNilai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bNilai();
            }
        });

        // Trans button click event
        btnTrans.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bTrans();
            }
        });

        // Absen button click event
        btnAbsen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bAbsen();
            }
        });
        // Petunjuk button click event
        btnPetunjuk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bPetunjuk();
            }
        });

//--------------------

    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(Activity_Main.this, Activity_Login.class);
        startActivity(intent);
        finish();
    }

    //------------------
    //tambah btnUniversitas click
    private void bUniversitas() {
        // Launching the Universitas activity
        Intent intent = new Intent(Activity_Main.this, Activity_Universitas_Intro.class);
        startActivity(intent);
        // finish();
    }

    //tambah btnUniversitas click
    private void bAkademik() {
        // Launching the Universitas activity
        Intent intent = new Intent(Activity_Main.this, Activity_Akademik_Intro.class);
        startActivity(intent);
        // finish();
    }

    //tambah btnUniversitas click
    private void bExtrakurikuler() {
        // Launching the Universitas activity
        Intent intent = new Intent(Activity_Main.this, Activity_Extrakurikuler_Intro.class);
        startActivity(intent);
        //   finish();
    }
    //tambah btnUniversitas click
    private void bJadwal() {
        // Launching the Universitas activity
        Intent intent = new Intent(Activity_Main.this, MainJadwalActivity.class);
        startActivity(intent);
        //  finish();
    }
    //tambah btnUniversitas click
    private void bNilai() {
        // Launching the Universitas activity
       // Intent intent = new Intent(Activity_Main.this, KhsActivity.class);
        Intent intent = new Intent(Activity_Main.this, MainKhsActivity.class);
        startActivity(intent);
        // finish();
    }

    //tambah btnUniversitas click
    private void bTrans() {
        // Launching the Universitas activity
        // Intent intent = new Intent(Activity_Main.this, KhsActivity.class);
        Intent intent = new Intent(Activity_Main.this, MainTransActivity.class);
        startActivity(intent);
        // finish();
    }


    //tambah btnAbsen click
    private void bAbsen() {
        // Launching the Absen activity
        Intent intent = new Intent(Activity_Main.this, MainAbsenActivity.class);
        startActivity(intent);
        //  finish();
    }
    //tambah btnPetnjuk click
    private void bPetunjuk() {
        // Launching the Petunjuk activity
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Aplikasi Monitoring Pendidikan Mahasiswa");
        alertDialog.setMessage("Petunjuk Penggunaan Aplikasi :\n"+
                " 1. Login / Register\n " +
                " 2. Pilih Menu yang dibutuhkan\n " +
                " 3. Click di List Informasi untuk melihat lebih detil\n " +
                " 4. Gunakan tombol Back untuk kembali ke list Informasi\n " +
                " 5. Log Out Aplikasi\n " +
                " 6. Tutup Aplikasi\n " +
                " \n\nTugas Akhir Kuliah\nBy @Intan 2016");

        //noinspection deprecation,deprecation
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
        //  finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}



