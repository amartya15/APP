package com.example.grosoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Tablerequest extends AppCompatActivity {
    ListView li;
    ArrayList<bookrequest> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablerequest);
        li= findViewById(R.id.livv);
        dbclass db = new dbclass(Tablerequest.this);


        data = db.getit();
        Log.e("Size",""+data.size());

        Bookrequestadapter a = new Bookrequestadapter(data,Tablerequest.this);
        li.setAdapter(a);
    }

    public void back(View view) {
        Intent i =new Intent(Tablerequest.this,Afteruser.class);
        startActivity(i);
    }
}
