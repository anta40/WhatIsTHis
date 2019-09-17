package com.anta40.app.whatisthis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;


public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    private PrefStartUp pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pref = new PrefStartUp(getApplicationContext());

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                // jika user belum login
                if (!pref.isLoggedIn()) {

                    // dan ini baru pertama kali menjalankan app, tampilkan wizard
                    if (pref.isFirstTimeLaunch()) {
                        Intent i = new Intent(getApplicationContext(), WizardActivity.class);
                        startActivity(i);
                        finish();
                    }

                    // OK ternyata sudah pernah menjalankan wizard. tampilkan halaman login
                    else {
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                }

                // ternyata sudah login, maka masuk ke halaman utama
                else {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }

}
