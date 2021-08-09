package com.example.salesenquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class welcome extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
Button signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        firebaseAuth=FirebaseAuth.getInstance();
        signout=findViewById(R.id.signout);
        signoutbut();
    }

    private void signoutbut() {
    signout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // logout - go to log in page (sign out your log in account) -- Module page
            firebaseAuth.signOut();
            Toast.makeText(getApplicationContext(),"Log Out Sucessful",Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(getApplicationContext(),login.class));
        }
    });
    }
}