package com.example.salesenquiry.EnquiryFrom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.R;
import com.google.android.material.textfield.TextInputEditText;

import static android.content.ContentValues.TAG;

public class personal_2 extends AppCompatActivity {
    Spinner occupation;
    TextView next,previous,gendertxt,statustxt,personaltxt;
    RadioGroup gender,status;
    RadioButton selectedGender,selectedStatus,male,female,married,unmarried;
    TextInputEditText CompanyName, Designation, WorkNature, BLocation;
    String companyname, designation, worknature, busiloc, occupationss;
    String occupations[] = {"Salary", "Business", "Professional", "Retired", "Student"};
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    String getGenderVal,getStatusval;
    Boolean genederData,statusData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal2);
        personaltxt=findViewById(R.id.personaltxt);
        gendertxt=findViewById(R.id.gendertxt);
        statustxt=findViewById(R.id.statustxt);
        gender=findViewById(R.id.genderval);
        status=findViewById(R.id.statusval);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        married=findViewById(R.id.married);
        unmarried=findViewById(R.id.unmarried);
        occupation = findViewById(R.id.spinner);
        CompanyName = findViewById(R.id.CompanyName);
        Designation = findViewById(R.id.designation);
        WorkNature = findViewById(R.id.worknature);
        BLocation = findViewById(R.id.busiloc);
        next =findViewById(R.id.next);
        previous =findViewById(R.id.previous);
        //Occupation Spineer
        occupationfeild();
        //Intents
        nextclick();
        previousclick();
//        //updateData
        UpdateFormData();
        //gender RadioButton
        gendervalget();
        //status Radiobutton
        statusvalget();
    }
//
    //Update Form Value
    private void UpdateFormData() {
        genederData=getIntent().getBooleanExtra("GENDER",true);
        if (genederData.equals(male.getText().toString())) {
            male.setChecked(true);
        }
        else if (genederData.equals(female.getText().toString())){
            female.setChecked(true);
        }
        statusData=getIntent().getBooleanExtra("STATUS",true);
        if (statusData.equals(married.getText().toString())) {
            married.setChecked(true);
        }
        else if (statusData.equals(unmarried.getText().toString())){
            unmarried.setChecked(true);
        }
        CompanyName.setText(getIntent().getStringExtra("COMPANY_NAME"));
        Designation.setText(getIntent().getStringExtra("DESIGNATION"));
        WorkNature.setText(getIntent().getStringExtra("WORK_NATURE"));
        BLocation.setText(getIntent().getStringExtra("BUSINESS_LOCATION"));
    }
    //Gender value get
    private void gendervalget() {
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.male == checkedId){
                    getGenderVal +=male.getText().toString();
                }
                else if (R.id.female == checkedId){
                    getGenderVal +=female.getText().toString();
                }
            }
        });
    }

    //Status Value get
    private void statusvalget() {
        status.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.married == checkedId){
                    getStatusval +=married.getText().toString();
                }
                else if (R.id.unmarried == checkedId){
                    getStatusval +=unmarried.getText().toString();
                }
            }
        });
    }



    //previous activity
    private void previousclick() {
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), personal.class);
                intent.putExtra("ID",getIntent().getIntExtra("ID",0));
                intent.putExtra("FNAME",getIntent().getStringExtra("FNAME"));
                intent.putExtra("LNAME",getIntent().getStringExtra("LNAME"));
                intent.putExtra("LOCALITY",getIntent().getStringExtra("LOCALITY"));
                intent.putExtra("CITY",getIntent().getStringExtra("CITY"));
                intent.putExtra("PINCODE",getIntent().getStringExtra("PINCODE"));
                intent.putExtra("TIME_TO_CALL",getIntent().getStringExtra("TIME_TO_CALL"));
                intent.putExtra("PHONE",getIntent().getStringExtra("PHONE"));
                intent.putExtra("ALTPHONE",getIntent().getStringExtra("ALTPHONE"));
                intent.putExtra("EMAIL",getIntent().getStringExtra("EMAIL"));
                startActivity(intent);
            }
        });
    }


//Next Activity
    private void nextclick() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    companyname = CompanyName.getText().toString();
                    designation = Designation.getText().toString();
                    worknature = WorkNature.getText().toString();
                    busiloc = BLocation.getText().toString();
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
                sp= getSharedPreferences("DetailsKey",MODE_PRIVATE);
                ed= sp.edit();
                ed.putString("GENDER",getGenderVal);
                ed.putString("STATUS",getStatusval);
                ed.putString("COMPANY_NAME", companyname);
                ed.putString("OCCUPATION", occupationss);
                ed.putString("DESIGNATION", designation);
                ed.putString("WORKNATURE", worknature);
                ed.putString("BUSINESS_LOC", busiloc);
                ed.apply();
                Intent intent = new Intent(getApplicationContext(), need_require.class);
                intent.putExtra("ID",getIntent().getStringExtra("ID"));
                //need and requirement
                intent.putExtra("CONFIGURATION",getIntent().getStringExtra("CONFIGURATION"));
                intent.putExtra("SPECIFY",getIntent().getStringExtra("SPECIFY"));
                intent.putExtra("BUDGET",getIntent().getStringExtra("BUDGET"));
                intent.putExtra("HOMELOAN",getIntent().getStringExtra("HOMELOAN"));
                intent.putExtra("BANKNAME",getIntent().getStringExtra("BANKNAME"));
                intent.putExtra("PURCHASE",getIntent().getStringExtra("PURCHASE"));
                intent.putExtra("RESIDENTAL",getIntent().getStringExtra("RESIDENTAL"));
                //about project
                intent.putExtra("NEWSPAPER_ADV",getIntent().getStringExtra("NEWSPAPER_ADV"));
                intent.putExtra("NEWSPAPER_INSERT",getIntent().getStringExtra("NEWSPAPER_INSERT"));
                intent.putExtra("HORDING",getIntent().getStringExtra("HORDING"));
                intent.putExtra("ADVERTISMENT",getIntent().getStringExtra("ADVERTISMENT"));
                intent.putExtra("SOURCE",getIntent().getStringExtra("SOURCE"));
                intent.putExtra("TELECALLING",getIntent().getStringExtra("TELECALLING"));
                intent.putExtra("REFER",getIntent().getStringExtra("REFER"));
                intent.putExtra("PARTNER",getIntent().getStringExtra("PARTNER"));
                startActivity(intent);
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
               // occupation.setSelection(getIntent().getBooleanExtra("OCCUPATION",true)[position].toString(),true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                occupationss = "Null";
            }
        });
    }
}