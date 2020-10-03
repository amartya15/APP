package com.example.grosoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
final  int SPLASH_TIMEOUT = 2000;

Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context=this;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                SharedPreferences sc=context.getSharedPreferences("user details",Context.MODE_PRIVATE);
                SharedPreferences sp=context.getSharedPreferences("userlog details",Context.MODE_PRIVATE);
                String usernamead=sc.getString("usernamead","");
                String passwordad=sc.getString("passwordad","");
                String username=sp.getString("username","");
                int userid=sp.getInt("userid",0);
                String password=sp.getString("password","");

                if(username.length()!=0)
                {
                    Intent i = new Intent(splash.this,Afteruser.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(i);
                }

                 else if(usernamead.length()!=0)
                {
                    Intent i = new Intent(splash.this,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(i);
                }
                 else
                 {
                     Intent i = new Intent(splash.this,Aftersplash.class);
                     i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                     startActivity(i);

                 }



            }
        },SPLASH_TIMEOUT);
    }

}
