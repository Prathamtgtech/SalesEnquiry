package com.example.salesenquiry.EnquiryFrom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.salesenquiry.R;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class personal extends AppCompatActivity {
    TextInputEditText Timer, Name, Locality, City, Pincode, Phone, AltPhone, Email;
    TimePickerDialog timePickerDialog;
    Button next;
    Calendar calendar;
    int currentHour;
    int currentMin;
    String ampm;
    String name,locality,city,timers,emailid,phone,altphone;
    int pincode;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);
        Timer = findViewById(R.id.timetocall);
        Name = findViewById(R.id.Name);
        Locality = findViewById(R.id.Locality);
        City = findViewById(R.id.City);
        Pincode = findViewById(R.id.Pincode);
        Phone = findViewById(R.id.Phone);
        AltPhone = findViewById(R.id.AltPhone);
        Email = findViewById(R.id.Emailid);
        next=(Button)findViewById(R.id.Next);

        //Timer
        TimpePicker();
        //nextbut
        nextbut();

          }


//    @Override
//    protected void onSaveInstanceState(@NonNull @NotNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("Name",name);
//        outState.putString("Locality",locality);
//        outState.putString("City",city);
//        outState.putInt("Pincodes", pincode);
//        outState.putString("Timers",timers);
//        outState.putString("Phones", phone);
//        outState.putString("AltPhones", altphone);
//        outState.putString("Emails",emailid);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    String names=savedInstanceState.getString("Name");
//    String localitys=savedInstanceState.getString("Locality");
//        String citys=savedInstanceState.getString("City");
//        int pincode=savedInstanceState.getInt("Pincodes");
//        String timer=savedInstanceState.getString("Timers");
//        String phone=savedInstanceState.getString("Phones");
//        String altphone=savedInstanceState.getString("AltPhones");
//        String emails=savedInstanceState.getString("Emails");
//
//        Name.setText(names);
//        Locality.setText(localitys);
//        City.setText(citys);
//        Pincode.setText(pincode);
//        Timer.setText(timer);
//        Phone.setText(phone);
//        AltPhone.setText(altphone);
//        Email.setText(emails);
//    }


    private void nextbut() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = Name.getText().toString();
                locality = Locality.getText().toString();
                city = City.getText().toString();
                emailid = Email.getText().toString();
                timers = Timer.getText().toString();
                phone = Phone.getText().toString();
                altphone = AltPhone.getText().toString();
                //pass values
                try {
                    pincode = Integer.parseInt(Pincode.getText().toString());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                //Share Prefrence
                sp =getSharedPreferences("DetailsKey",MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();
                ed.putString("Name",name);
                ed.putString("Locality",locality);
                ed.putString("City",city);
                ed.putInt("Pincodes", pincode);
                ed.putString("Timers",timers);
                ed.putString("Phones", phone);
                ed.putString("AltPhones", altphone);
                ed.putString("Emails",emailid);

                Log.d("Values",""+name+locality+city+pincode+timers+phone+altphone+emailid);
                ed.apply();
                Intent intent=new Intent(getApplicationContext(),personal_2.class);
                startActivity(intent);
            }
        });

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