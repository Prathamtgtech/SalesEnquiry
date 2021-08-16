package com.example.salesenquiry.EnquiryFrom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.EnquiryFormDatabase.Enq_Database;
import com.example.salesenquiry.EnquiryFormDatabase.FormDetails;
import com.example.salesenquiry.R;
import com.google.android.material.textfield.TextInputEditText;

public class about_project extends AppCompatActivity {
    TextView pleasure, aboutproject, printadv,demo;
    CheckBox news1, news2, news3, news4;
    TextInputEditText newspaper, hording, digital, telecalling, source, refer, partner;
    String Advertise="",insertpaper,hordindloc,digitals,sources,refers,partners;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_project);
        pleasure = findViewById(R.id.pleasuretxt);
        aboutproject = findViewById(R.id.aboutproject);
        printadv = findViewById(R.id.printadv);
        news1 = findViewById(R.id.news1);
        news2 = findViewById(R.id.news2);
        news3 = findViewById(R.id.news3);
        news4 = findViewById(R.id.news4);
        newspaper = findViewById(R.id.newsinsert);
        hording = findViewById(R.id.hording);
        digital = findViewById(R.id.digital);
        telecalling = findViewById(R.id.telecalling);
        source = findViewById(R.id.source);
        refer = findViewById(R.id.refer);
        demo=findViewById(R.id.demo);
        partner = findViewById(R.id.partner);
        printadvertisment();
    submitbut();


    }


    //Print Advertisment
    private void printadvertisment() {

        news1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news1.isChecked()) {
                    Advertise +="Times Of India";
                }
            }
        });
        news2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news2.isChecked()) {
                    Advertise += "Hindusatan Times";
                }
            }
        });
        news3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news3.isChecked()) {
                    Advertise += "Mid-Day";
                }
            }
        });
        news4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news4.isChecked()) {
                    Advertise = "Mumbai Mirror";
                }
            }
        });
    }

    //Submit Button
    private void submitbut() {
        insertpaper=newspaper.getText().toString();
        hordindloc=hording.getText().toString();
        digitals=printadv.getText().toString();
        sources=source.getText().toString();
        refers=refer.getText().toString();
        partners=partner.getText().toString();
        SharedPreferences sp = getSharedPreferences("DetailsKey", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("Advertises",Advertise);
        ed.putString("INSERT",insertpaper );
        ed.putString("HORDING", hordindloc);
        ed.putString("ADVERTISMENT",digitals);
        ed.putString("SOURCE", sources);
        ed.putString("REFER",refers);
        ed.putString("PARTNER",partners);
        ed.putString("TELE", telecalling.getText().toString());
        ed.apply();
        }
    }