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

public class Afteruser extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences sc = getSharedPreferences("user details",MODE_PRIVATE);
        SharedPreferences sp = getSharedPreferences("userlog details",MODE_PRIVATE);


        sc.edit().clear().commit();
        sp.edit().clear().commit();
        Intent intent=new Intent(Afteruser.this,Aftersplash.class);
        startActivity(intent);
        finish();
        Toast.makeText(Afteruser.this, "logout sucessfully", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afteruser);
        ScrollView constraintLayout = findViewById(R.id.afteruser);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }



    public void add(View view) {
        Intent i=new Intent(Afteruser.this,Aftercatagory.class);
        startActivity(i);
    }


    public void addhorror(View view) {
        Intent i=new Intent(Afteruser.this,Horroruser.class);
        startActivity(i);

    }

    public void addhumour(View view) {
        Intent i = new Intent(Afteruser.this,Humour.class);
        startActivity(i);
    }
    public void addromantic(View view) {
        Intent i = new Intent(Afteruser.this,Romantic.class);
        startActivity(i);
    }
    public void addclassic(View view) {
        Intent i = new Intent(Afteruser.this,ClassicActivity.class);
        startActivity(i);
    }
    public void addmythology(View view) {
        Intent i = new Intent(Afteruser.this,Mythology.class);
        startActivity(i);
    }
}
