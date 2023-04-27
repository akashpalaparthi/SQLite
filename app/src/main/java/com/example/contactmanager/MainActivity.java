package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
FloatingActionButton fBtn;
ArrayList<String> name,number;
    MyDataBase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        fBtn=findViewById(R.id.fBtn);
        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Add_Activity.class);
                startActivity(intent);
            }
        });
        name=new ArrayList<>();
        number=new ArrayList<>();
         mydb=new MyDataBase(MainActivity.this);
         setData();
         adapter adpt=new adapter(MainActivity.this,name,number);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         recyclerView.setAdapter(adpt);

    }
    void setData(){
        Cursor cursor=mydb.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){

                name.add(cursor.getString(1));
                number.add(cursor.getString(2));
            }
        }
    }


}