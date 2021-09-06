package com.example.salesenquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.Database.LoginDB;
import com.google.android.material.textfield.TextInputEditText;

public class forgot_password extends AppCompatActivity {
TextView changetxt;
TextInputEditText password,changepassword;
Button confirm;
LoginDB loginDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        loginDB=new LoginDB(this);
        changetxt=findViewById(R.id.changetxt);
        password=findViewById(R.id.passwordtxt);
        changepassword=findViewById(R.id.confirmpass);
        confirm=findViewById(R.id.confirm);

        updatepassword();
    }

    private void updatepassword() {
    confirm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String User=getIntent().getStringExtra("User");
            String Password=password.getText().toString();
            String ChangePassword=changepassword.getText().toString();
            if (ChangePassword.equals(Password)) {
                Boolean changePassword = loginDB.changepassword(User, Password);
                if (changePassword == true) {
                    Toast.makeText(getApplicationContext(), "Password Changed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Password Changed Failed", Toast.LENGTH_LONG).show();
                }
            }
        }
    });
    }
}