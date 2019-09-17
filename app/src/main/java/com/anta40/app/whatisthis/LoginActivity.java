package com.anta40.app.whatisthis;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    PrefStartUp pref;
    Button btnLogin;
    EditText inputNama, inputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = new PrefStartUp(getApplicationContext());
        inputNama = (EditText) findViewById(R.id.input_nama);
        inputEmail = (EditText) findViewById(R.id.input_email);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputNama.getText().toString().equals(("Linus Torvalds")) && inputEmail.getText().toString().equals("linus@kernel.org")){
                    Toast.makeText(getApplicationContext(), "Login berhasil.", Toast.LENGTH_LONG).show();
                    pref.createLoginSession(inputNama.getText().toString(), inputEmail.getText().toString());
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login gagal. Harap ulangi.", Toast.LENGTH_LONG).show();
                }
            }}
        );


    }
}
