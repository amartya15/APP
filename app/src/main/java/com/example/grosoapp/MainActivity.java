package com.example.grosoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class  MainActivity extends AppCompatActivity {
    ListView li;
    ArrayList<bookstructure> data;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences sc = getSharedPreferences("user details",MODE_PRIVATE);
        sc.edit().clear().commit();
        Intent intent=new Intent(MainActivity.this,Aftersplash.class);
        startActivity(intent);
        finish();
        Toast.makeText(MainActivity.this, "logout sucessfully", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li= findViewById(R.id.li);
        dbclass db = new dbclass(MainActivity.this);


        data = db.getallbooks();
        adapter a = new adapter(data,MainActivity.this);
        li.setAdapter(a);

    }

    public void addbook(View view) {
        Intent i = new Intent(MainActivity.this,addbook.class);
        startActivity(i);

    }

    public void see(View view) {
        Intent i= new Intent (MainActivity.this,Tablerequest.class);
        startActivity(i);

    }
}

