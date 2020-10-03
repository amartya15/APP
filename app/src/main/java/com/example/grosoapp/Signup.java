package com.example.grosoapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    EditText uuuusername,ppppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        uuuusername = findViewById(R.id.eduser);
        ppppassword = findViewById(R.id.edpassword);
        RelativeLayout constraintLayout = findViewById(R.id.layoutsign);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    public void save(View view) {
        String username =  uuuusername.getText().toString();
        String password  =  ppppassword.getText().toString();


        int flag=1;
        if(username.length()==0)
        {
            uuuusername.setError("Please Enter name!");
            flag=0;
        }
        if(password.length()==0)
        {
            ppppassword.setError("Please Enter password!");
            flag=0;
        }

        if(flag==1) {
            dbclass db = new dbclass(Signup.this);
            db.addlogin(username,password);
            Toast.makeText(Signup.this, "update sucessfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Signup.this, Userlogin.class);
            startActivity(i);
        }
    }
    }

