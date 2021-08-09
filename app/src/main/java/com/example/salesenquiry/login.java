package com.example.salesenquiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    ImageView logo;
    TextInputEditText email, password;
    View Login, fb, google;
    TextView orline, donthave, signupac;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Login = findViewById(R.id.login);
        signupac = findViewById(R.id.signupac);
        logo=findViewById(R.id.logoIcon);
        email=findViewById(R.id.emailtxt);
        password=findViewById(R.id.passwordtxt);
        orline=findViewById(R.id.orline);
        donthave=findViewById(R.id.donthave);
        fb=findViewById(R.id.fb);
        google=findViewById(R.id.signupac);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //if user is note null then open module activity
        if (user != null) {
            finish();
            startActivity(new Intent(login.this, welcome.class));
        }
        signuptext();
        loginbut();

    }

    private void loginbut() {
        //after click on log in button verify the details and go to modules page --- log in page
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(email.getText().toString(),password.getText().toString());
            }
        });
    }

    //firebase authentication is use to verify details store in firebase --- Log in page
    public void check(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(login.this,"Log in Sucessful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(login.this,welcome.class));
                }
                else {
                    Toast.makeText(login.this,"Try again",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //SignUpText
    private void signuptext() {
        signupac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), register.class);
                startActivity(intent);
            }
        });
    }
}