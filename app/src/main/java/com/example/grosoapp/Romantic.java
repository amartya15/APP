package com.example.grosoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Romantic extends AppCompatActivity {
    ListView li;
    ArrayList<bookstructure> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romantic);
        li = findViewById(R.id.li);

        dbclass db = new dbclass(Romantic.this);


        data = db.getallromantic();
        final Adapteruser a = new Adapteruser(data, Romantic.this);
        li.setAdapter(a);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bookstructure b = data.get(i);
                if (b.isIsselected()) {
                    b.setIsselected(false);
                } else
                    b.setIsselected(true);
                data.set(i, b);
                a.updaterecord(data);
            }
        });

    }
}


