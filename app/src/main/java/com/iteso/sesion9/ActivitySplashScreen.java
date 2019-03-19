package com.iteso.sesion9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.iteso.sesion9.beans.User;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadUser();
                Intent intent;
                if(user.isLogged()){
                    intent = new Intent(ActivitySplashScreen.this, MainActivity.class);
                }else {
                    intent = new Intent(ActivitySplashScreen.this, ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }

    public User loadUser(){
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.sesion9.PREFERENCES", MODE_PRIVATE);

        User user = new User();
        user.setUsername(sharedPreferences.getString("USERNAME", null));
        user.setPassword(sharedPreferences.getString("PASSWORD", null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED", false));
        sharedPreferences = null;
        return  user;
    }
}
