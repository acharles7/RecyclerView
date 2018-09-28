package com.example.charles.lab2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class ParentActivity extends AppCompatActivity{

    EditText editName,editTitle,editSubTitle;
    Button btn,btn2;
    ChaDbSchema chaDbSchema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_activity);
        chaDbSchema = new ChaDbSchema(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editTitle = (EditText)findViewById(R.id.editText_surname);
        editSubTitle = (EditText)findViewById(R.id.editText_Marks);
        btn = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(),MainActivity.class));
                boolean isResult = chaDbSchema.insertData(editName.getText().toString(),
                        editTitle.getText().toString(),
                        editSubTitle.getText().toString());


                if(isResult == true)
                    Toast.makeText(ParentActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ParentActivity.this,"Not Inserted",Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParentActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
