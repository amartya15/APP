package com.example.grosoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ClassicActivity extends AppCompatActivity {

    ListView li;
    ArrayList<bookstructure> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classic);

        li = findViewById(R.id.clas);

        dbclass db = new dbclass(ClassicActivity.this);


        data = db.getallclassic();
        final Adapteruser a = new Adapteruser(data, ClassicActivity.this);
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
