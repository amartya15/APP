package com.example.grosoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

class dbclass extends SQLiteOpenHelper {

    public dbclass(Context context) {
        super(context,"sample" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqll = "create table bookstructure(bookid INTEGER PRIMARY KEY,name TEXT,author TEXT, number REAL,category TEXT) ";
        String sql = "create table user(id INTEGER PRIMARY KEY,usernamead TEXT,passwordad TEXT)";
        sqLiteDatabase.execSQL(sql);
        String sql2 = "insert into user(usernamead,passwordad) values ('library','12345')";
        sqLiteDatabase.execSQL(sql2);
        String sql13="create table userlog(userid INTEGER PRIMARY KEY,username TEXT,password TEXT)";
        sqLiteDatabase.execSQL(sql13);
        String sql14="create table bookrequest(username TEXT,bookid INTEGER)";
        sqLiteDatabase.execSQL(sql14);


        sqLiteDatabase.execSQL(sqll);
        String sql5 = "create table showbooks(bookid INTEGER PRIMARY KEY,name TEXT,author TEXT, number REAL,category TEXT) ";
        sqLiteDatabase.execSQL(sql5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql = "drop table bookstructure";

        db.execSQL(sql);
        this.onCreate(db);
    }


    public void requestBook(String username, String bookid )
    {

        String sql14="insert into bookrequest(username,bookid) values ('"+username+"','"+bookid+"')";
        SQLiteDatabase db= this.getWritableDatabase();
        Log.e("SQL",sql14);
        db.execSQL(sql14 );
    }

   public ArrayList<bookrequest> getit(){
       ArrayList<bookrequest> data = new ArrayList<>();



       String sql14 = " select * from bookrequest ";
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor= db.rawQuery(sql14,null);
       if(cursor.moveToFirst())
       {
           do{
               String username = cursor.getString(0);
               int bookid= cursor.getInt(1);






              bookrequest c = new bookrequest(username,bookid);
               data.add(c);
           }while (cursor.moveToNext());
       }
       return  data;

   }

    public void addbooks(String name,String author, int number,String category){

        String sql ="insert into bookstructure(name,author,number,category) values ('"+name+"','"+author+"', '"+number+"' ,'"+category+"')";

        SQLiteDatabase db= this.getWritableDatabase();
        Log.e("SQL",sql);
        db.execSQL(sql);

    }
    public void showbooks1(String name,String author, int number,String category){

        String sql12 ="insert into showbooks(name,author,number,category) values ('"+name+"','"+author+"', '"+number+"' ,'"+category+"')";

        SQLiteDatabase db= this.getWritableDatabase();
        Log.e("SQL",sql12);
        db.execSQL(sql12);

    }

    public void updateBook(String name,String author,int number,int bookid,String category)
    {
        String sql = "update bookstructure set name='"+name+"',author='"+author+"',number="+number+",category='"+category+"' where bookid='"+bookid+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

    }
    public void deleteBook(int bookid)
    {

        String sql = "delete from bookstructure where bookid='"+bookid+"'";
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);
    }




    public ArrayList<bookstructure> getallbooks() {
        ArrayList<bookstructure> data = new ArrayList<>();



        String sql = " select * from bookstructure ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                int number = cursor.getInt(3);
                int bookid = cursor.getInt(0);
                String category = cursor.getString(4);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,author,number,bookid,category);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }
    public ArrayList<bookstructure> getallhorror() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category = 'horror' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                int number = cursor.getInt(3);
                int bookid = cursor.getInt(0);
                String category = cursor.getString(4);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,author,number,bookid,category);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }

    public ArrayList<bookstructure> getallromantic() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category = 'romantic' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                int number = cursor.getInt(3);
                int bookid = cursor.getInt(0);
                String category = cursor.getString(4);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,author,number,bookid,category);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }

    public ArrayList<bookstructure> getallhumour() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category = 'humour' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                int number = cursor.getInt(3);
                int bookid = cursor.getInt(0);
                String category = cursor.getString(4);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,author,number,bookid,category);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }

    public ArrayList<bookstructure> getallmythology() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category ='mythology'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                int number = cursor.getInt(3);
                int bookid = cursor.getInt(0);
                String category = cursor.getString(4);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,author,number,bookid,category);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }

    public ArrayList<bookstructure> getallclassic() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category = 'classic'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                int number = cursor.getInt(3);
                int bookid = cursor.getInt(0);
                String category = cursor.getString(4);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,author,number,bookid,category);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }


    public user checklogin(String usernamead,String passwordad)
    {
        user u= null;
        String sql = "select * from user where usernamead ='"+usernamead+"' and passwordad ='"+passwordad+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c= db.rawQuery(sql,null);
        if(c.moveToFirst())
        {
            int id = c.getInt(0);
            String uusernamead = c.getString(1);
            String ppasswordad  = c.getString(2);
            u = new user(id,uusernamead,ppasswordad);
        }
        return u;
    }
    public void addlogin(String username,String password)
    {

        String sql13 ="insert into userlog(username,password) values ('"+username+"','"+password+"')";
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL(sql13);

    }
    public userlog userlogin(String username,String password) {
        userlog uu = null;
        String sql = "select * from userlog where username ='" + username + "' and password ='" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            int userid = c.getInt(0);
            String uuusername = c.getString(1);
            String pppassword = c.getString(2);
            uu = new userlog(userid, uuusername, pppassword);
        }
        return uu;
    }


}
