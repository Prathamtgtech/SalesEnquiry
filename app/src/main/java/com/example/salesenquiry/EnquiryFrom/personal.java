package com.example.salesenquiry.EnquiryFrom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.salesenquiry.Database.FormDB;
import com.example.salesenquiry.R;
import com.example.salesenquiry.forgot_password;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

public class personal extends AppCompatActivity {
    TextInputEditText Timer, FirstName,LastName, Locality, City, Pincode, Phone, AltPhone, Email;
    TimePickerDialog timePickerDialog;
    Button next;
    Calendar calendar;
    int currentHour;
    int currentMin;
    String ampm;
    String fname,lname,locality,city,timers,emailid,phone,altphone;
    int pincode;
    SharedPreferences sp;
    Cursor cursor;
    ArrayList<DataModel> dataView=new ArrayList<DataModel>();
    DataModel dataModel;
    FormDB formDB;
    Bundle bundle,UpdateBundle;
    public final static int REQUEST_CODE_DATA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);

        FirstName = findViewById(R.id.FirstName);
        LastName=findViewById(R.id.LastName);
        Locality = findViewById(R.id.Locality);
        City = findViewById(R.id.City);
        Pincode = findViewById(R.id.Pincode);
        Timer = findViewById(R.id.timetocall);
        Phone = findViewById(R.id.Phone);
        AltPhone = findViewById(R.id.AltPhone);
        Email = findViewById(R.id.Emailid);
        next=(Button)findViewById(R.id.Next);
       cursor=new FormDB(this).FetchCustData();
       bundle=getIntent().getExtras();
       UpdateBundle=getIntent().getExtras();
        //Timer
        TimpePicker();
        //nextbut
        nextbut();
       //updateData
        UpdateFormData();

          }


//    //Update Form Data
    private void UpdateFormData() {
        Log.d("CheckId"," "+getIntent().getIntExtra("ID",0));
        //Personal Details
        FirstName.setText(getIntent().getStringExtra("FNAME"));
        LastName.setText(getIntent().getStringExtra("LNAME"));
        Locality.setText(getIntent().getStringExtra("LOCALITY"));
        City.setText(getIntent().getStringExtra("CITY"));
        Pincode.setText(String.valueOf(getIntent().getStringExtra("PINCODE")));
        Timer.setText(getIntent().getStringExtra("TIME_TO_CALL"));
        Phone.setText(getIntent().getStringExtra("PHONE"));
        AltPhone.setText(getIntent().getStringExtra("ALTPHONE"));
        Email.setText(getIntent().getStringExtra("EMAIL"));

    }
//Validation
    public boolean validation(){
        fname = FirstName.getText().toString();
        lname= LastName.getText().toString();
        locality = Locality.getText().toString();
        city = City.getText().toString();
        emailid = Email.getText().toString();
        timers = Timer.getText().toString();
        phone = Phone.getText().toString();
        altphone = AltPhone.getText().toString();

        //validation values values
        try {
            pincode = Integer.parseInt(Pincode.getText().toString());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        if(fname.isEmpty() || lname.isEmpty() || phone.isEmpty() || altphone.isEmpty()) {
            FirstName.setError("Details Are Mandatory");
            LastName.setError("Details Are Mandatory");
            Phone.setError("Details Are Mandatory");
            AltPhone.setError("Details Are Mandatory");
            return false;
        }
        else{
            FirstName.setError(null);
            LastName.setError(null);
            Phone.setError(null);
            AltPhone.setError(null);
            return true;
        }

    }

    private void nextbut() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Validation
                if (!validation()){
                    return;
                }
                //Share Prefrence
                sp =getSharedPreferences("DetailsKey",MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();
                ed.putString("FNAME",fname);
                ed.putString("LNAME",lname);
                ed.putString("LOCALITY",locality);
                ed.putString("CITY",city);
                ed.putInt("PINCODE", pincode);
                ed.putString("TIMER",timers);
                ed.putString("PHONE", phone);
                ed.putString("ALTPHONE", altphone);
                ed.putString("EMAIL",emailid);
                Log.d("DataOfFist",sp.getString("FNAME",""));
                ed.apply();
                Intent intent=new Intent(getApplicationContext(),personal_2.class);
                //Update Data Intent
                intent.putExtra("ID",getIntent().getIntExtra("ID",0));
                intent.putExtra("GENDER",getIntent().getBooleanExtra("GENDER",true));
                intent.putExtra("STATUS",getIntent().getStringExtra("STATUS"));
                intent.putExtra("OCCUPATION",getIntent().getStringExtra("OCCUPATION"));
                intent.putExtra("COMPANY_NAME",getIntent().getStringExtra("COMPANY_NAME"));
                intent.putExtra("DESIGNATION",getIntent().getStringExtra("DESIGNATION"));
                intent.putExtra("WORK_NATURE",getIntent().getStringExtra("WORK_NATURE"));
                intent.putExtra("BUSINESS_LOCATION",getIntent().getStringExtra("BUSINESS_LOCATION"));
                //need and requirement
                intent.putExtra("CONFIGURATION",getIntent().getStringExtra("CONFIGURATION"));
                intent.putExtra("SPECIFY",getIntent().getStringExtra("SPECIFY"));
                intent.putExtra("BUDGET",getIntent().getStringExtra("BUDGET"));
                intent.putExtra("HOMELOAN",getIntent().getStringExtra("HOMELOAN"));
                intent.putExtra("BANKNAME",getIntent().getStringExtra("BANKNAME"));
                intent.putExtra("PURCHASE",getIntent().getStringExtra("PURCHASE"));
                intent.putExtra("RESIDENTAL",getIntent().getStringExtra("RESIDENTAL"));
                //about project
                intent.putExtra("NEWSPAPER_ADV",getIntent().getStringExtra("NEWSPAPER"));
                intent.putExtra("NEWSPAPER_INSERT",getIntent().getStringExtra("ENTER_NEWSPAPER"));
                intent.putExtra("HORDING",getIntent().getStringExtra("HORDING"));
                intent.putExtra("ADVERTISMENT",getIntent().getStringExtra("ADVERTISMENT"));
                intent.putExtra("SOURCE",getIntent().getStringExtra("SOURCE"));
                intent.putExtra("TELECALLING",getIntent().getStringExtra("TELECALLING"));
                intent.putExtra("BROKER",getIntent().getStringExtra("BROKER"));
                intent.putExtra("REFER",getIntent().getStringExtra("REFER"));
                //Bundle Data
                BundleData(intent);
                //resultCode
                startActivityForResult(intent,REQUEST_CODE_DATA);
                finish();
            }
        });

    }
    //Passing Data To New Activity Using Bundle
    private void BundleData(Intent intent) {
        bundle=new Bundle();
        bundle.putString("FNAME",fname);
        bundle.putString("LNAME",lname);
        bundle.putString("LOCALITY",locality);
        bundle.putString("CITY",city);
        bundle.putInt("PINCODE",pincode);
        bundle.putString("TIME_TO_CALL",timers);
        bundle.putString("PHONE",phone);
        bundle.putString("ALTPHONE",altphone);
        bundle.putString("EMAIL",emailid);
        intent.putExtras(bundle);
    }
    //TimePicker
    private void TimpePicker () {

        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMin = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(personal.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 12) {
                            ampm = "PM";
                        } else {
                            ampm = "AM";
                        }
                        Timer.setText(String.format("%02d:%02d", hourOfDay, minute) + ampm);
                    }
                }, currentHour, currentMin, false);
                timePickerDialog.show();
            }
        });
    }
}