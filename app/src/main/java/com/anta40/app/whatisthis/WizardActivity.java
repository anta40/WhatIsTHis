package com.anta40.app.whatisthis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WizardActivity extends AppCompatActivity {

    Button btnOK;
    PrefStartUp pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

        pref = new PrefStartUp(getApplicationContext());
        pref.setFirstTimeLaunch(false);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
               // finish();

                //Toast.makeText(getApplicationContext(), "AAAAAAAAAAAAAA", Toast.LENGTH_LONG).show();
            }
        });
    }
}
