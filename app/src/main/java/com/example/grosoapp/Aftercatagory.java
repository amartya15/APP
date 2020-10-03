package com.example.grosoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Aftercatagory extends AppCompatActivity {

    ListView li;
    ArrayList<bookstructure> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftercatagory);
      /*  LinearLayout constraintLayout = findViewById(R.id.layout3);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/

        li= findViewById(R.id.lii);

        dbclass db = new dbclass(Aftercatagory.this);


        data = db.getallbooks();
        final Adapteruser a = new Adapteruser(data,Aftercatagory.this);
        li.setAdapter(a);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bookstructure b = data.get(i);
                if(b.isIsselected())
                {
                    b.setIsselected(false);
                }
                else
                    b.setIsselected(true);
                data.set(i,b);
                a.updaterecord(data);
            }
        });

    }


}


