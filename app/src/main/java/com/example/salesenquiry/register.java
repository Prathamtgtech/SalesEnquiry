package com.example.salesenquiry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.Database.LoginDB;
import com.example.salesenquiry.EnquiryFrom.SignupDataModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class register extends AppCompatActivity {
    ImageView logo;
    TextInputEditText name, email, password;
    View signup;
    TextView haveac, login;
    LoginDB loginDB;
    FirebaseAuth firebaseAuth;
    String Fullname, Username, Password;
    FirebaseDatabase db;
    Cursor cursor;
    SignupDataModel signupDataModel;
    DatabaseReference reference;
    ArrayList<SignupDataModel> dataview = new ArrayList<SignupDataModel>();

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
        loginDB = new LoginDB(this);
        cursor = new LoginDB(this).FetchLoginData();
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        reference = db.getReference("Sales Enquiry").child("User Details").child("Id");
        logintxt();
        //Enter Details in Feild
        EnterDetails();
    }

    //Enter Details In Feilds
    private void EnterDetails() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fullname = name.getText().toString();
                Username = email.getText().toString();
                Password = password.getText().toString();
                //firebase
                if (Fullname.isEmpty()||Username.isEmpty() || Password.isEmpty()) {
                  Toast.makeText(getApplicationContext(),"Fill The Details",Toast.LENGTH_LONG).show();
                }
                else{
                    FirebaseStoreData();
                }
                //Firebase Value get From Sqlite
                //firebaseDatabase();
              //Sq Lite
               // SqliteStoreData();

            }
        });
    }
    //Firebase Realtime Database
    private void firebaseDatabase() {
        while (cursor.moveToNext()) {
            signupDataModel = new SignupDataModel();
            signupDataModel.setId(cursor.getInt(0));
            signupDataModel.setFULLNAME(cursor.getString(1));
            signupDataModel.setUSERNAME(cursor.getString(2));
            signupDataModel.setPASSWORD(cursor.getString(3));
            dataview.add(signupDataModel);
        }
        reference.setValue(dataview);
    }

    //Store Data In Firebase
    private void FirebaseStoreData() {
        firebaseAuth.createUserWithEmailAndPassword(Username, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseAuth.getCurrentUser().sendEmailVerification()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    Toast.makeText(register.this, "Email Has Been Sent In Email", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(register.this, login.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(register.this, "Not verified Your Email", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Toast.makeText(register.this, "Login Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //If register form is empty show msg fill the form --Register page
    private boolean check(){
        boolean result=false;
        String fullname=name.getText().toString();
        String user_name = email.getText().toString();
        String user_password = password.getText().toString();
        if(fullname.isEmpty() ||  user_name.isEmpty() || user_password.isEmpty()  ){
            Toast.makeText(this,"Fill The Form",Toast.LENGTH_LONG).show();
        }
        else{
            result=true;
        }
        return result;
    }
   // Sqlite Store Database
    public void SqliteStoreData() {
        if (Fullname.isEmpty() || Username.isEmpty() || Password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill All The Details", Toast.LENGTH_LONG).show();
        } else {
            Boolean checkuser = loginDB.checkUsername(Username);
            if (checkuser == false) {
                Boolean insert = loginDB.insertData(Fullname, Username, Password);
                if (insert = true) {
                    Toast.makeText(getApplicationContext(), "Register Sucessfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), login.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Register Failed Please Sign Up", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "User Already Exists", Toast.LENGTH_LONG).show();
            }
        }
    }

    //Go to Register Activity
    private void logintxt() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}