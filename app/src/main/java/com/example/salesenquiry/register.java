package com.example.salesenquiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.Database.LoginDB;
import com.google.android.material.textfield.TextInputEditText;

public class register extends AppCompatActivity {
    ImageView logo;
    TextInputEditText name, email, password;
    View signup;
    TextView haveac, login;
    LoginDB loginDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name = findViewById(R.id.nametxt);
        signup = findViewById(R.id.signup);
        haveac = findViewById(R.id.haveac);
        logo = findViewById(R.id.logoIcon);
        email = findViewById(R.id.emailtxt);
        password = findViewById(R.id.passwordtxt);
        haveac = findViewById(R.id.haveac);
        login = findViewById(R.id.loginac);
        loginDB=new LoginDB(this);
        logintxt();
        //Enter Details in Feild
        EnterDetails();
    }
//Enter Details In Feilds
    private void EnterDetails() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String Fullname=name.getText().toString();
             String Username=email.getText().toString();
             String Password=password.getText().toString();

             if (Fullname.isEmpty() ||Username.isEmpty() ||Password.isEmpty()){
                 Toast.makeText(getApplicationContext(),"Fill All The Details",Toast.LENGTH_LONG).show();
             }
             else {
                 Boolean checkuser=loginDB.checkUsername(Username);
                 if (checkuser==false){
                     Boolean insert=loginDB.insertData(Fullname,Username,Password);
                     if (insert=true){
                         Toast.makeText(getApplicationContext(),"Register Sucessfully",Toast.LENGTH_LONG).show();
                         Intent intent=new Intent(getApplicationContext(),login.class);
                         startActivity(intent);
                     }
                     else {
                         Toast.makeText(getApplicationContext(),"Register Failed Please Sign Up",Toast.LENGTH_LONG).show();
                     }
                 }
                 else{
                     Toast.makeText(getApplicationContext(),"User Already Exists",Toast.LENGTH_LONG).show();
                 }
             }
            }
        });
    }
    //Go to Register Activity
    private void logintxt(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}