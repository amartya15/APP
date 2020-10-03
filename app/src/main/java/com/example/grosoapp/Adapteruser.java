package com.example.grosoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapteruser extends BaseAdapter {
    ArrayList<bookstructure> data;
    Context c;
    LayoutInflater in;
    int bookid;

    public Adapteruser(ArrayList<bookstructure> data, Context c) {
        this.data = data;
        this.c = c;
        in = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        Viewholder holder = null;
        if (view == null) {
            view  = in.inflate(R.layout.userka, viewGroup, false);

        holder = new Viewholder();
         holder.nam = view.findViewById(R.id.nam);
        holder.pos = view.findViewById(R.id.pos);
        holder.poi = view.findViewById(R.id.poi);
        holder.ch = view.findViewById(R.id.check);
        view.setTag(holder);

    }else

            holder = (Viewholder) view.getTag();
            bookstructure b = data.get(i);
            holder.pos.setText(b.getAuthor());
            holder.nam.setText(b.getName());
            holder.poi.setText("" + b.getNumber());

            if(b.isIsselected())
            {
                holder.ch.setBackgroundResource(R.drawable.checked);
            }
            else
            {
                holder.ch.setBackgroundResource(R.drawable.checkboxoutline);


            }
        ImageView request=view.findViewById(R.id.request);
        request.setTag(i);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos =(int)view.getTag();

                int uid=data.get(pos).bookid;



                SharedPreferences sp =c.getSharedPreferences("userlog details", Context.MODE_PRIVATE);

                String username= (String) sp.getString("username", String.valueOf(1));



                dbclass db = new dbclass(c);
                db.requestBook(""+username,""+uid);

                Toast.makeText(c,"Book requested successfully!!",Toast.LENGTH_LONG).show();

                /*Intent intent=new Intent(c,Tablerequest.class);

                intent.putExtra("bookid",uid);
                intent.putExtra("userid",userid);
                c.startActivity(intent);*/

            }
        });

      return  view;
    }
    public  void updaterecord(ArrayList<bookstructure> data)
    {
        this.data=data;
        notifyDataSetChanged();
    }
    class Viewholder
    {

        TextView nam;
        TextView pos ;
        TextView poi ;
        ImageView ch;




    }

}
