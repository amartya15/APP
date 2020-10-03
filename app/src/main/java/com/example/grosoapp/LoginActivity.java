package com.example.grosoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText uuusername,pppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uuusername = findViewById(R.id.eduser);
        pppassword = findViewById(R.id.edpassword);
        RelativeLayout constraintLayout = findViewById(R.id.layout5);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

    }

    public void loginmy(View view) {

        dbclass db = new dbclass(LoginActivity.this);
        String usernamead=uuusername.getText().toString();
        String passwordad = pppassword.getText().toString();
       user u = db.checklogin(usernamead,passwordad);
        if(u!=null)
        {
            Toast.makeText(LoginActivity.this,"login successful!!!",Toast.LENGTH_LONG).show();
            SharedPreferences sc =this.getSharedPreferences("user details", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sc.edit();
            editor.putString("usernamead",u.usernamead);
            editor.putString("passwordad",u.passwordad);
           editor.commit();


            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);

        }
        else {
            Toast.makeText(LoginActivity.this,"login unsuccessful!!!",Toast.LENGTH_LONG).show();

        }

    }
}
