package com.example.salesenquiry.EnquiryFrom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.Database.FormDatabase;
import com.example.salesenquiry.R;
import com.google.android.material.textfield.TextInputEditText;

public class about_project extends AppCompatActivity {
    TextView pleasure, aboutproject, printadv;
    CheckBox news1, news2, news3, news4;
    TextInputEditText newspaper, hording, digital, telecalling, source, refer, partner;
    String Advertise = "", insertpaper, hordindloc, digitals, sources, refers, partners;
    FormDatabase formDatabase;
    SharedPreferences sp;
Button submit;
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
        partner = findViewById(R.id.partner);
        submit=findViewById(R.id.submit);
        formDatabase = new FormDatabase(this);
        printadvertisment();
        submitbut();
    }



    //Print Advertisment
    private void printadvertisment() {

        news1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news1.isChecked()) {
                    Advertise += "Times Of India";
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
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertpaper = newspaper.getText().toString();
                hordindloc = hording.getText().toString();
                digitals = digital.getText().toString();
                sources = source.getText().toString();
                refers = refer.getText().toString();
                partners = partner.getText().toString();
                sp = getSharedPreferences("DetailsKey", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("NEWSPAPER", Advertise);
                ed.putString("PAPERNAME", insertpaper);
                ed.putString("HORDING", hordindloc);
                ed.putString("ADVERTISMENT", digitals);
                ed.putString("SOURCE", sources);
                ed.putString("REFER", refers);
                ed.putString("PARTNER", partners);
                ed.putString("TELE", telecalling.getText().toString());
                ed.apply();
                String Name =sp.getString("Name","");
                String Locality =sp.getString("Locality","");
                String City =sp.getString("City","");
                int Pincode =sp.getInt("Pincodes",0);
                String Timetocall=sp.getString("Timers","");
                String Phone=sp.getString("Phones","");
                String Altphone=sp.getString("AltPhones","");
                String Email=sp.getString("Emails","");
                String Education=sp.getString("Education","");
                String Occupation=sp.getString("Occupation","");
                String Company_name=sp.getString("CompanyName","");
                String Designation=sp.getString("Designation","");
                String Work_natures=sp.getString("WorkNature","");
                String Business_location=sp.getString("BusinessLocation","");
                String Configuration=sp.getString("Configurtaion","");
                String Specify=sp.getString("SPECIFY","");
                String Budget=sp.getString("BUDGET","");
                String Loan=sp.getString("Loan","");
                String Bankname=sp.getString("BankName","");
                String Purchase=sp.getString("Purchase","");
                String Residantal=sp.getString("Residantal","");
                String Newspaper=sp.getString("NEWSPAPER","");
                String Insert_newspaper=sp.getString("INSERT","");
                String Hording=sp.getString("HORDING","");
                String Advertisement=sp.getString("ADVERTISMENT","");
                String Telecalling=sp.getString("TELE","");
                String Source=sp.getString("SOURCE","");
                String Refer=sp.getString("REFER","");
                String Partner=sp.getString("PARTNER","");

                Boolean insertData=formDatabase.InsertValues(Name,Locality,City,Pincode,Timetocall,Phone,Altphone,Email,Education,Occupation,Company_name,Designation,Work_natures,Business_location,Configuration,Specify,Budget,Loan,Bankname,Purchase,Residantal,Newspaper,Insert_newspaper,Hording,Advertisement,Telecalling,Source,Refer,Partner);
                if (insertData==true){
                    startActivity(new Intent(getApplicationContext(),com.example.salesenquiry.welcome.class));
                    Toast.makeText(getApplicationContext(),"Details Are Submitted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Details Are Not Submitted",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}