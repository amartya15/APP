package com.example.grosoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class catagory extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences sc = getSharedPreferences("user details",MODE_PRIVATE);
        sc.edit().clear().commit();
        Intent intent=new Intent(catagory.this,Aftersplash.class);

        startActivity(intent);
        finish();
        Toast.makeText(catagory.this, "logout sucessfully", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
        ScrollView constraintLayout = findViewById(R.id.catagory);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

    }


    public void add(View view) {
        Intent i=new Intent(catagory.this,MainActivity.class);
        startActivity(i);
    }


    public void romantic(View view) {
    }

    public void humour(View view) {
    }
}
