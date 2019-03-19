package com.iteso.sesion9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.activity_username);
        password = findViewById(R.id.activity_password);
        login = findViewById(R.id.activity_save);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences( "com.iteso.sesion9.PREFERENCES", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("USERNAME", username.getText().toString());
                editor.putString("PASSWORD", password.getText().toString());
                editor.putBoolean("LOGGED" ,true);
                editor.apply();
                Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
