package com.example.salesenquiry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    ImageView logo;
    TextInputEditText fullname, email, password;
    View signup, fb, google;
    TextView orline, haveac, login;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullname = findViewById(R.id.nametxt);
        setContentView(R.layout.register);
        signup = findViewById(R.id.signup);
        haveac = findViewById(R.id.haveac);
        logo = findViewById(R.id.logoIcon);
        email = findViewById(R.id.emailtxt);
        password = findViewById(R.id.passwordtxt);
        orline = findViewById(R.id.orline);
        haveac = findViewById(R.id.haveac);
        fb = findViewById(R.id.fb);
        firebaseAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.loginac);
        google = findViewById(R.id.google);

        logintxt();
        signupbut();

    }

    private void signupbut() {
    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (check()) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Details Submit", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), login.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }
        //If register form is empty show msg fill the form --Register page
        private boolean check(){
            boolean result=false;
//            String fname=fullname.getText().toString();
            String useremail = email.getText().toString();
            String userpassword = password.getText().toString();
            if(useremail.isEmpty() || userpassword.isEmpty() ){
                Toast.makeText(getApplicationContext(),"Fill The Form",Toast.LENGTH_LONG).show();
            }
            else{
                result=true;
            }
            return result;
        }
    });
    }


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