package com.example.grosoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addbook extends AppCompatActivity {
    EditText edname,edauthor,edno,edcat,edlication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        edname = findViewById(R.id.edname);
        edauthor = findViewById(R.id.edaut);
        edno = findViewById(R.id.edno);
        edcat = findViewById(R.id.edcat);
        edlication=findViewById(R.id.edlocation);


      /*  LinearLayout constraintLayout = findViewById(R.id.layout2);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
    }

    public void addnewbook(View view) {
        String name = edname.getText().toString();
        String category = edcat.getText().toString();
        String author = edauthor.getText().toString();
        String location=edlication.getText().toString();
        int number=0;
        try {
            number = Integer.parseInt(edno.getText().toString());
        }catch (Exception e)
        {
            Log.e("exception",e.toString());
        }
        int flag=1;
        if(name.length()==0)
        {
            edname.setError("Please Enter name!");
            flag=0;
        }
        if(author.length()==0)
        {
            edauthor.setError("Please Enter author name!");
            flag=0;
        }
        if(category.length()==0)
        {
            edauthor.setError("Please Enter author name!");
            flag=0;
        }
        if(location.length()==0)
        {
            edlication.setError("Please Enter author name!");
            flag=0;
        }
        if(flag==1) {
            dbclass db = new dbclass(addbook.this);
            db.addbooks(name,author,number,category);
            Toast.makeText(addbook.this, "update sucessfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(addbook.this, MainActivity.class);
            startActivity(i);

        }
    }
}
