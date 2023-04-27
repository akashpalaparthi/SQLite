package com.example.contactmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    private Context context;
    private static final String Dbname="Contacts DB";
    private static final int version=1;
    private static final String TableName="Contacts";
    private static final String Col_id="id";
    private static final String Col_name="name";
    private static final String Col_number="number";
    public MyDataBase(@Nullable Context context) {
        super(context, Dbname, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TableName+"("+Col_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Col_name+" TEXT,"+Col_number+" TEXT);" ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
          String query="DROP TABLE IF EXISTS "+TableName;
          db.execSQL(query);
          onCreate(db);
    }
    void AddData(String name,String number){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col_name,name);
        cv.put(Col_number,number);
        long res=db.insert(TableName,null,cv);
        if(res ==-1){
            Toast.makeText(context, "FAILED", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "ADDED", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData(){
        String query="SELECT * FROM "+TableName;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }

}
