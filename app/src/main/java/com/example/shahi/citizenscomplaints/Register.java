package com.example.shahi.citizenscomplaints;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private EditText edcitName ,edPhone , edId ,edAddress;
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
        edId = findViewById(R.id.edNational);
        edAddress = findViewById(R.id.edAdd);
        regist = findViewById(R.id.btnRegister);
        regist.setOnClickListener(this);
        progressDialog =new ProgressDialog(this);
    }

    private void registerUser(){
        final String name=edcitName.getText().toString().trim();
        final String pho= edPhone.getText().toString().trim();
        final String id=edId.getText().toString() +"@gmail.com".trim();
        final String add=edAddress.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pho)){

            Toast.makeText(this,"Please Phone",Toast.LENGTH_SHORT).show();

        }

        if(TextUtils.isEmpty(id)){

            Toast.makeText(this,"Please Enter Your Id",Toast.LENGTH_SHORT).show();

        } if(TextUtils.isEmpty(add)) {

            Toast.makeText(this,"Please Enter Your Address",Toast.LENGTH_SHORT).show();

        }
        progressDialog.setMessage("^^...Please Wait...^^");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(id , pho).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    User use=new User(
                            name,pho, id ,add);
                    FirebaseDatabase.getInstance().getReference("Citizens Data")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            . setValue(use)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        finish();
                                        startActivity(new Intent(getApplicationContext(),NewComp.class));

                                    }
                                    else{
                                        Toast.makeText(Register.this,"Not Successful",Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });
                }
                else {
                    Toast.makeText(Register.this, "Authentication failed:" + task.getException(), Toast.LENGTH_SHORT).show();

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
