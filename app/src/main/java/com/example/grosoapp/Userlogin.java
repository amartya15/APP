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

public class Userlogin extends AppCompatActivity {
    EditText sername,assword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin2);
        sername = findViewById(R.id.eduser);
        assword = findViewById(R.id.edpassword);
        RelativeLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    public void userlog(View view) {
        dbclass db = new dbclass(Userlogin.this);
        String username=sername.getText().toString();
        String password = assword.getText().toString();
        userlog uu = db.userlogin(username,password);
        if(uu!=null)
        {
            Toast.makeText(Userlogin.this,"login successful!!!",Toast.LENGTH_LONG).show();
            SharedPreferences sp =this.getSharedPreferences("userlog details", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("username",uu.username);
            editor.putString("password",uu.password);
            editor.putInt("userid",uu.userid);
            editor.commit();


            Intent i = new Intent(Userlogin.this,Afteruser.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);

        }
        else {
            Toast.makeText(Userlogin.this,"login unsuccessful!!!",Toast.LENGTH_LONG).show();

        }

    }

    public void sign(View view) {
        Intent intent=new Intent(Userlogin.this,Signup.class);
        startActivity(intent);
    }
}
