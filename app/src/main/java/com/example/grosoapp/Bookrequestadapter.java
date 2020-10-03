package com.example.grosoapp;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Bookrequestadapter extends BaseAdapter {

    ArrayList<bookrequest> data;
    Context c;
    LayoutInflater in;

    public Bookrequestadapter(ArrayList<bookrequest> data, Context c) {
        this.data = data;
        this.c = c;
        in = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


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
        View v = in.inflate(R.layout.requestuser,null);
        TextView username = v.findViewById(R.id.userid);
        TextView bookid = v.findViewById(R.id.bookid);





        Log.e("id",""+data.get(i).bookid);
             username.setText(data.get(i).username);
            bookid.setText(""+data.get(i).bookid);




        return v;
    }
}
