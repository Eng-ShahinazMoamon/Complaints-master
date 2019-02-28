package com.example.shahi.citizenscomplaints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText idNo;
    private Button btLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idNo=findViewById(R.id.edIdNo);
        btLog=findViewById(R.id.logQuery);
        btLog.setOnClickListener(this);

    }

    public void loginUser() {

        final String id = idNo.getText().toString() + "@gmail.com".trim();

        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "Please Enter Id", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View v) {
        if(v==btLog){
            loginUser();

        }

    }
}
