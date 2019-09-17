package com.anta40.app.whatisthis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    PrefStartUp pref;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = (Button) findViewById(R.id.btnLogout);

        pref = new PrefStartUp(getApplicationContext());
        HashMap<String, String> user_data = pref.getUserDetails();

        String nama = user_data.get(PrefStartUp.KEY_NAMA);
        String email = user_data.get(PrefStartUp.KEY_EMAIL);

        Toast.makeText(getApplicationContext(), "Nama: "+nama+", email: "+email, Toast.LENGTH_LONG).show();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref.logoutUser();
            }
        });
    }
}
