package com.example.grosoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adapter extends BaseAdapter {
    ImageView image;
    public static final int pick_image = 1;
    ArrayList<bookstructure> data;
    Context c;
    LayoutInflater in;
    int bookid;

    public adapter(ArrayList<bookstructure> data, Context c) {
        this.data = data;
        this.c = c;
        in = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = in.inflate(R.layout.lists, null);
        TextView nam = v.findViewById(R.id.nam);
        TextView pos = v.findViewById(R.id.pos);
        TextView poi = v.findViewById(R.id.poi);
        TextView cat = v.findViewById(R.id.cat);
        CheckBox ch = v.findViewById(R.id.check);
        ImageView edit = v.findViewById(R.id.update);
        ImageView icondelete = v.findViewById(R.id.delete);
        image = v.findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                ((Activity) c).startActivityForResult(Intent.createChooser(intent, "select pivture"), pick_image);

            }

        });
       /* @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1) {
                String filepath = data.getDataString();
                Toast.makeText(getActivity(), "Hello onActivityResult", Toast.LENGTH_SHORT).show();
            }
        }
*/










        

        edit.setTag(i);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos =(int)view.getTag();
                String uname=data.get(pos).name;
                String uauthor=data.get(pos).author;
                String ucategory=data.get(pos).category;
                int unumber=data.get(pos).number;
                int uid=data.get(pos).bookid;
                Intent intent=new Intent(c,Updatethis.class);
                intent.putExtra("name",uname);
                intent.putExtra("author",uauthor);
                intent.putExtra("number",unumber);
                intent.putExtra("category",ucategory);
                intent.putExtra("bookid",uid);
                c.startActivity(intent);


            }
        });
        icondelete.setTag(i);
        icondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=(int)view.getTag();
                bookid = data.get(pos).bookid;
                AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(c);
                alertdialogbuilder.setTitle("do you want to delete this item from the list ?");
                alertdialogbuilder.setMessage("click yes to delete");
                alertdialogbuilder.setCancelable(false);
                alertdialogbuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbclass db= new dbclass(c);
                        db.deleteBook(bookid);
                        Toast.makeText(c,"book deleted sucesfully!!!",Toast.LENGTH_LONG).show();;
                        Intent intent=new Intent(c,MainActivity.class);
                        c.startActivity(intent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                dialog.cancel();


            }
        });
                AlertDialog alertDialog=alertdialogbuilder.create();
                alertDialog.show();
            }
        });



        nam.setText(data.get(i).name);
        pos.setText(data.get(i).author);
        cat.setText(data.get(i).category);
        poi.setText(""+data.get(i).number);
        ch.isChecked();

        return  v;


    }





}

