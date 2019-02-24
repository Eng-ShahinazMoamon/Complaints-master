package com.example.shahi.citizenscomplaints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText edcitName ,edPhone ,edPassword , edId ,edAddress;
    Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edcitName=findViewById(R.id.edCit);
        edPhone=findViewById(R.id.edPho);
        edPassword=findViewById(R.id.edPass);
        edId=findViewById(R.id.edNational);
        edAddress=findViewById(R.id.edAdd);
        regist=findViewById(R.id.btnRegister);


    }
}
