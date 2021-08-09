package com.example.salesenquiry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.Database.CustomerDetails;
import com.example.salesenquiry.Database.MyDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    ImageView logo;
    TextInputEditText fullname, email, password;
    View signup;
    TextView orline, haveac, login;
    CustomerDetails customerDetails;

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
        haveac = findViewById(R.id.haveac);

        login = findViewById(R.id.loginac);
        logintxt();
        //Enter Details in Feild
        EnterDetails();
    }
//Enter Details In Feilds
    private void EnterDetails() {
    String Name=fullname.getText().toString();
    String user_email=email.getText().toString();
    String user_password=password.getText().toString();

        MyDatabase myDatabase= Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "DB_CUSTOMER")
                .allowMainThreadQueries().build();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    customerDetails = new CustomerDetails(Name, user_email, user_password);
                    if (customerDetails != null) {
                        myDatabase.Dao().SignUpDetails(customerDetails);
                        Toast.makeText(getApplicationContext(), "Details Submit", Toast.LENGTH_LONG);
                    } else {
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please Fill All Details",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean check() {
    boolean result=false;
    String user_name=fullname.getText().toString();
    String user_email=email.getText().toString();
    String user_password=password.getText().toString();

    if (user_email.isEmpty() || user_name.isEmpty() || user_password.isEmpty()){
        Toast.makeText(getApplicationContext(),"Fill All The Details",Toast.LENGTH_LONG).show();
    }
    else{
        result=true;
    }
    return result;
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