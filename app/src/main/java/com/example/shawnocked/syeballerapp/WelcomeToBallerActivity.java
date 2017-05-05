package com.example.shawnocked.syeballerapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.EOFException;

/**
 * Created by shawnocked on 3/28/17.
 */

public class WelcomeToBallerActivity extends Activity {
    TextView welcome;
    Button solo;
    Button halfcourt;
    Button fullcourt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcometoballer);

        welcome =(TextView) findViewById(R.id.welcometoballer);
        solo = (Button) findViewById(R.id.solo);
        halfcourt = (Button) findViewById(R.id.half_court);
        fullcourt = (Button) findViewById(R.id.full_court);

        solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WelcomeToBallerActivity.this, "Ed let me graduate PLEASE", Toast.LENGTH_SHORT).show();
            }
        });

        halfcourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WelcomeToBallerActivity.this, "Ed let me graduate PLEASE", Toast.LENGTH_SHORT).show();
            }
        });

        fullcourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WelcomeToBallerActivity.this, "Ed let me graduate PLEASE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
