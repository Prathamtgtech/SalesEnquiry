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
import com.example.salesenquiry.Database.DAO;
import com.example.salesenquiry.Database.MyDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    ImageView logo;
    TextInputEditText name, email, password;
    View signup;
    TextView haveac, login;
    CustomerDetails customerDetails;
    MyDatabase myDatabase;
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
        myDatabase= Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "Customer_Details")
                .allowMainThreadQueries().build();
        login = findViewById(R.id.loginac);
        logintxt();
        //Enter Details in Feild
        EnterDetails();
    }
//Enter Details In Feilds
    private void EnterDetails() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerDetails=new CustomerDetails();
                customerDetails.setName(name.getText().toString());   ;
                customerDetails.setEmail(email.getText().toString());
                customerDetails.setPassword(password.getText().toString());
                if (customerDetails.getName().isEmpty() || customerDetails.getEmail().isEmpty() || customerDetails.getPassword().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fills The Details",Toast.LENGTH_LONG).show();
                }
                else {
                    DAO dao=myDatabase.getDao();
                    if (customerDetails!=null){
                        dao.SignUpDetails(customerDetails);
                        Toast.makeText(getApplicationContext(),"Details Are Submitted",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_LONG).show();
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