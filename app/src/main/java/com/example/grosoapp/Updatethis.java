package com.example.grosoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

;

public class Updatethis extends AppCompatActivity {

    String name,author,category;
    int number;
    int bookid;

    EditText edname,edauthor,ednum,edcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatethis);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        author = bundle.getString("author");
        number=bundle.getInt("number");
        category= bundle.getString("category");
        bookid = bundle.getInt("bookid");

        edname = (EditText) findViewById(R.id.edname);
        edauthor = (EditText) findViewById(R.id.edaut);
        ednum=(EditText)findViewById(R.id.edno);
        edcategory=findViewById(R.id.edcat);
        edname.setText(name);
        edauthor.setText(author);
        edcategory.setText(category);
        ednum.setText(""+number);
    }

    public void addnewbook(View view) {

        String name = edname.getText().toString();
        String author= edauthor.getText().toString();
        String category = edcategory.getText().toString();
        int number = Integer.parseInt(ednum.getText().toString());

        dbclass db = new dbclass(Updatethis.this);
        db.updateBook(name,author,number,bookid,category);

        Toast.makeText(Updatethis.this,"Data Updated successfully!!",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Updatethis.this,MainActivity.class);
        startActivity(intent);

    }
}
