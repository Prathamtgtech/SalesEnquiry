package com.example.salesenquiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.salesenquiry.Database.LoginDB;
import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {
    ImageView logo;
    TextInputEditText email, password;
    View loginBut;
    TextView donthave, signupac, forgot;
    LoginDB loginDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginBut = findViewById(R.id.login);
        signupac = findViewById(R.id.signupac);
        logo = findViewById(R.id.logoIcon);
        email = findViewById(R.id.emailtxt);
        password = findViewById(R.id.passwordtxt);
        donthave = findViewById(R.id.donthave);
        forgot = findViewById(R.id.forgot);
        loginDB=new LoginDB(this);
        //SignUpButton
        signupbut();
        //log in Button
        loginButton();
    }

    //Log in button
    private void loginButton() {
        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(getApplicationContext(),welcome.class));
//                String Username=email.getText().toString();
//                String Password=password.getText().toString();
//
//                if (Username.isEmpty() ||Password.isEmpty()){
//                    Toast.makeText(getApplicationContext(),"Fill The Details",Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Boolean loginData=loginDB.checkusernamepassword(Username,Password);
//                    if (loginData==true){
//                        Toast.makeText(getApplicationContext(),"Log In Sucessfully",Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(getApplicationContext(),welcome.class));
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(),"Log In Failed",Toast.LENGTH_LONG).show();
//                    }
//                }
            }
        });
    }


    //Go to Login Activity
    private void signupbut() {
        signupac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), register.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}

