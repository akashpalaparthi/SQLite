package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Activity extends AppCompatActivity {
    EditText edtName,edtNumber;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edtName=findViewById(R.id.edtName);
        edtNumber=findViewById(R.id.edtNumber);
        btnsave=findViewById(R.id.btnSave);

      btnsave.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              MyDataBase myDb=new MyDataBase(Add_Activity.this);
              myDb.AddData(edtName.getText().toString().trim(),edtNumber.getText().toString().trim());

          }
      });
    }
}