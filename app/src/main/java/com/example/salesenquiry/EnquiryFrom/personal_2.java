package com.example.salesenquiry.EnquiryFrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.R;
import com.google.android.material.textfield.TextInputEditText;

import static android.content.ContentValues.TAG;

public class personal_2 extends AppCompatActivity {
    Spinner occupation;
    TextView next, previous, demo;
    TextInputEditText Education, CompanyName, Designation, WorkNature, BLocation;
    String education, companyname, designation, worknature, busiloc, occupationss;
    String occupations[] = {"Salary", "Business", "Professional", "Retired", "Student"};
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal2);
        occupation = findViewById(R.id.spinner);
        next = (TextView) findViewById(R.id.next);
        previous = (TextView) findViewById(R.id.previous);
        Education = findViewById(R.id.education);
        CompanyName = findViewById(R.id.CompanyName);
        demo = findViewById(R.id.demo);
        Designation = findViewById(R.id.designation);
        WorkNature = findViewById(R.id.worknature);
        BLocation = findViewById(R.id.busiloc);
        SharedPreferences sp= getSharedPreferences("DetailsKey",MODE_PRIVATE);
        String time=sp.getString("Timers","");
        demo.setText(""+ time);
        occupationfeild();
        buttonsclick(sp);

    }

    private void buttonsclick(SharedPreferences sp) {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    education = Education.getText().toString();
                    companyname = CompanyName.getText().toString();
                    designation = Designation.getText().toString();
                    worknature = WorkNature.getText().toString();
                    busiloc = BLocation.getText().toString();
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
                ed= sp.edit();
                ed.putString("Education", education);
                ed.putString("CompanyName", companyname);
                ed.putString("Occupation", occupationss);
                ed.putString("Designation", designation);
                ed.putString("WorkNature", worknature);
                ed.putString("BusinessLocation", busiloc);
                ed.apply();
                Intent intent = new Intent(getApplicationContext(), need_require.class);
                startActivity(intent);
                finish();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), personal.class));
                finish();
            }
        });
    }

    private void occupationfeild() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.occupation_item, occupations);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        occupation.setAdapter(arrayAdapter);
        occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                occupationss = (occupations[position].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                occupationss = "Null";
            }
        });
    }
}