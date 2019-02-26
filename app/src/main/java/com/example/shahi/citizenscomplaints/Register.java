package com.example.shahi.citizenscomplaints;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private EditText edcitName ,edPhone ,edPassword , edId ,edAddress;
    private Button regist;
    private ProgressDialog progressDialog;
    //define firebase object
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth=FirebaseAuth.getInstance();
        edcitName = findViewById(R.id.edCit);
        edPhone = findViewById(R.id.edPho);
        edPassword = findViewById(R.id.edPass);
        edId = findViewById(R.id.edNational);
        edAddress = findViewById(R.id.edAdd);
        regist = findViewById(R.id.btnRegister);
        regist.setOnClickListener(this);
        progressDialog =new ProgressDialog(this);
    }

    private void registerUser(){
        String name=edcitName.getText().toString().trim();
        String pho= edPhone.getText().toString().trim();
        String pass=edPassword.getText().toString().trim();
        String id=edId.getText().toString().trim();
        String add=edAddress.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pho)){

            Toast.makeText(this,"Please Phone",Toast.LENGTH_SHORT).show();

        }

        if(TextUtils.isEmpty(pass)){

            Toast.makeText(this,"Please Password",Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(id)){

            Toast.makeText(this,"Please Enter Your Id",Toast.LENGTH_SHORT).show();

        } if(TextUtils.isEmpty(add)) {

            Toast.makeText(this,"Please Enter Your Address",Toast.LENGTH_SHORT).show();

        }
        progressDialog.setMessage("^^...Please Wait...^^");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(id , pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this,"done",Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(Register.this,"fail",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == regist){
            registerUser();
        }

    }
}
