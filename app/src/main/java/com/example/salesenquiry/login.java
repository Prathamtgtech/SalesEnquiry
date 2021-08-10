package com.example.salesenquiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.salesenquiry.Database.CustomerDetails;
import com.example.salesenquiry.Database.DAO;
import com.example.salesenquiry.Database.MyDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    ImageView logo;
    MyDatabase myDatabase;
    TextInputEditText email, password;
    View loginBut;
    TextView donthave, signupac,forgot;
CustomerDetails customerDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginBut = findViewById(R.id.login);
        signupac = findViewById(R.id.signupac);
        logo=findViewById(R.id.logoIcon);
        email=findViewById(R.id.emailtxt);
        password=findViewById(R.id.passwordtxt);
        donthave=findViewById(R.id.donthave);
        forgot=findViewById(R.id.forgot);
        myDatabase=Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"CustomerDetails")
                .allowMainThreadQueries().build();
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
            String user_email=email.getText().toString().trim();
            String user_password=password.getText().toString().trim();
             if (user_email.isEmpty() || user_password.isEmpty()){
                 Toast.makeText(getApplicationContext(),"Fills All Details",Toast.LENGTH_LONG).show();
             }
             else {
                 customerDetails=myDatabase.getDao().UserDetails(user_email,user_password);
                 if (customerDetails == null){
                     Toast.makeText(getApplicationContext(),"Invalid Credantials",Toast.LENGTH_LONG).show();
                 }
                 else {
                     Toast.makeText(getApplicationContext(),"Log In Sucessful",Toast.LENGTH_LONG).show();
                     startActivity(new Intent(getApplicationContext(),welcome.class));
                 }
             }

        }
    });
    }


    //Go to Login Activity
    private void signupbut() {
        signupac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),register.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }


}
