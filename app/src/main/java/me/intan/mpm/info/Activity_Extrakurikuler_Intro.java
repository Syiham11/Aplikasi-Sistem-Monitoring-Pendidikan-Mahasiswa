package me.intan.mpm.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.intan.mpm.R;

public class Activity_Extrakurikuler_Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universitas_intro);


        Button btnUniversitas = (Button) findViewById(R.id.btnUniversitas);


        //-------------------------------------------------------------------------
        // Universitas button click event
        btnUniversitas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bUniversitas();
            }
        });

//--------------------

    }

    //------------------
    //tambah btnUniversitas click
    private void bUniversitas() {
        // Launching the Universitas activity
        Intent intent = new Intent(Activity_Extrakurikuler_Intro.this, ExtrakurikulerActivity.class);
        startActivity(intent);
        // finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}



