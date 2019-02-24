package com.example.shahi.citizenscomplaints;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{
    EditText edcitName ,edPhone ,edPassword , edId ,edAddress;
    Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edcitName = findViewById(R.id.edCit);
        edPhone = findViewById(R.id.edPho);
        edPassword = findViewById(R.id.edPass);
        edId = findViewById(R.id.edNational);
        edAddress = findViewById(R.id.edAdd);
        regist = findViewById(R.id.btnRegister);
        regist.setOnClickListener(this);
    }

    private void registerUser(){
        String name=edcitName.getText().toString().trim();
        String pho= edPhone.getText().toString().trim();
        String pass=edPassword.getText().toString().trim();
        String id=edId.getText().toString().trim();
        String add=edAddress.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT);
        }
        if(TextUtils.isEmpty(pho)){

            Toast.makeText(this,"Please Password",Toast.LENGTH_SHORT);

        }

        if(TextUtils.isEmpty(pass)){

            Toast.makeText(this,"Please Password",Toast.LENGTH_SHORT);

        }
        if(TextUtils.isEmpty(id)){

            Toast.makeText(this,"Please Enter Your Id",Toast.LENGTH_SHORT);

        } if(TextUtils.isEmpty(add)) {

            Toast.makeText(this,"Please Enter Your Address",Toast.LENGTH_SHORT);

        }
    }

    @Override
    public void onClick(View v) {
        if(v == regist){
            registerUser();
        }

    }
}
