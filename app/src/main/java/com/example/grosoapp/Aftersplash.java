package com.example.grosoapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Aftersplash extends AppCompatActivity {
    TextView tvhead,tvbelow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftersplash);
        tvhead=findViewById(R.id.textview);
        tvbelow=findViewById(R.id.usertext);
        RelativeLayout constraintLayout = findViewById(R.id.layout4);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

    }

    public void click(View view) {
        Intent intent=new Intent(Aftersplash.this,LoginActivity.class);
        startActivity(intent);
    }

    public void clicktouser(View view) {
        Intent intent=new Intent(Aftersplash.this,Userlogin.class);
        startActivity(intent);
    }
}
