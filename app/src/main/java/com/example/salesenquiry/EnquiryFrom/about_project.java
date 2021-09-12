package com.example.salesenquiry.EnquiryFrom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.Database.FormDB;
import com.example.salesenquiry.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.jar.Attributes;

public class about_project extends AppCompatActivity {
    Spinner newsadv, newsinsert;
    TextView pleasure, aboutproject, newsadvtxt, newsinserttxt;
    TextInputEditText hording, digital, telecalling, source, broker, reference;
    String hordindloc, digitals, sources, refernces, brokers, telecallings;
    FormDB formDB;
    SharedPreferences sp;
    Button submit, submitbut, updateData;
    Dialog submit_dialog, update_dialog;
    DataModel dataModel;
    DatabaseReference dbreference;
    Cursor cursor;
    String FName, LName, Locality, City, Timetocall, Phone, Altphone, Email,
            Gender, Status, Occupation, Company_name, Designation, Work_nature, Business_location,
            Configuration, Specify, Budget, Purchase, Loan, Bankname, Residantal,
            Newspaper_Adv, Newspaper_Insert, Hording, Advertisement, Telecalling, Source, Broker, Reference;
    int Pincode;
    String newsAdvOpt[] = {"Times Of India", "Mumbai Mirror,Mid-Day", "Navbhart Times", "Maharashtra Times", "Mumbai Samachar", "Gujrat Samachar", "Any Others"};
    String newsInsertOpt[] = {"Times Of India", "Mumbai Mirror,Mid-Day", "Navbhart Times", "Maharashtra Times", "Mumbai Samachar", "Gujrat Samachar", "Any Others"};
    ArrayList<DataModel> dataView = new ArrayList<DataModel>();
    FirebaseDatabase db;
    String newsadvval, newsinsertval;
    int FormId;
Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_project);
        pleasure = findViewById(R.id.pleasuretxt);
        aboutproject = findViewById(R.id.aboutproject);
        newsadvtxt = findViewById(R.id.newsadvtxt);
        newsinserttxt = findViewById(R.id.newsinserttxt);
        newsadv = findViewById(R.id.newsadv);
        newsinsert = findViewById(R.id.newsinsert);
        hording = findViewById(R.id.hording);
        digital = findViewById(R.id.digital);
        telecalling = findViewById(R.id.telecalling);
        source = findViewById(R.id.source);
        broker = findViewById(R.id.broker);
        reference = findViewById(R.id.refrence);
        submit = findViewById(R.id.submit);
        submit_dialog = new Dialog(this);
        update_dialog = new Dialog(this);
        //insert data in sqlite
        formDB = new FormDB(this);
        //firebase data get
        cursor = new FormDB(this).FetchCustData();
        db = FirebaseDatabase.getInstance();
        dbreference = db.getReference("Sales Enquiry").child("Customer Data").child("Id");
        FormId = getIntent().getIntExtra("ID", 0);
        bundle=getIntent().getExtras();
        //Newspaper Advertisment Spineer
        NewspaperAdv();
        //Newspaper Insert Spinner
        NewsaperInsert();
        submitbut();
//        //Update Form
        UpdateFormData();
    }

    //Newspaper Advertisment
    private void NewspaperAdv() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.newspaper_advertise, newsAdvOpt);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        newsadv.setAdapter(arrayAdapter);
        newsadv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newsadvval = (newsAdvOpt[position].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                newsadvval = "Null";
            }
        });
    }

    //Insert Newspaper
    private void NewsaperInsert() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.newspaper_insert, newsInsertOpt);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        newsinsert.setAdapter(arrayAdapter);
        newsinsert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newsinsertval = (newsInsertOpt[position].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                newsinsertval = "Null";
            }
        });
    }

    ////Form Update Data
    private void UpdateFormData() {
//    newspaper.setText(getIntent().getStringExtra("ENTER_NEWSPAPER"));
        hording.setText(getIntent().getStringExtra("HORDING"));
        digital.setText(getIntent().getStringExtra("ADVERTISMENT"));
        telecalling.setText(getIntent().getStringExtra("SOURCE"));
        source.setText(getIntent().getStringExtra("TELECALLING"));
        broker.setText(getIntent().getStringExtra("BROKER"));
        reference.setText(getIntent().getStringExtra("REFER"));
    }

    //Submit Details Dialog Box
    private void SubmitDialog() {
        submit_dialog.setContentView(R.layout.details_submit);
        submit_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        submitbut = submit_dialog.findViewById(R.id.detailsubmit);
        submitbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.salesenquiry.welcome.class);
                startActivity(intent);
                finish();
            }
        });
        submit_dialog.show();
    }

    //Update Dialog Box
//Submit Details Dialog Box
    private void UpdateDialog() {
        update_dialog.setContentView(R.layout.update_dialog);
        update_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        updateData = update_dialog.findViewById(R.id.dataupdate);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.salesenquiry.welcome.class);
                startActivity(intent);
                finish();
            }
        });
        update_dialog.show();
    }

    //Submit Button
    private void submitbut() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hordindloc = hording.getText().toString();
                digitals = digital.getText().toString();
                sources = source.getText().toString();
                brokers = broker.getText().toString();
                refernces = reference.getText().toString();
                telecallings = telecalling.getText().toString();
                sp = getSharedPreferences("DetailsKey", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("NEWSPAPER_ADV", newsadvval);
                ed.putString("NEWSPAPER_INSERT", newsinsertval);
                ed.putString("HORDINGS", hordindloc);
                ed.putString("DIGITAL_ADV", digitals);
                ed.putString("SOURCE", sources);
                ed.putString("BROKER", brokers);
                ed.putString("REFERENCE", refernces);
                ed.putString("TELECALLING", telecallings);
                ed.apply();
                FName = sp.getString("FNAME", "");
                LName = sp.getString("LNAME", "");
                Locality = sp.getString("LOCALITY", "");
                City = sp.getString("CITY", "");
                Pincode = sp.getInt("PINCODE", 0);
                Timetocall = sp.getString("TIMER", "");
                Phone = sp.getString("PHONE", "");
                Altphone = sp.getString("ALTPHONE", "");
                Email = sp.getString("EMAIL", "");
                Gender = sp.getString("GENDER", "");
                Status = sp.getString("STATUS", "");
                Occupation = sp.getString("OCCUPATION", "");
                Company_name = sp.getString("COMPANY_NAME", "");
                Designation = sp.getString("DESIGNATION", "");
                Work_nature = sp.getString("WORKNATURE", "");
                Business_location = sp.getString("BUSINESS_LOC", "");
                Configuration = sp.getString("CONFIGURATION", "");
                Specify = sp.getString("SPECIFY", "");
                Budget = sp.getString("BUDGETS", "");
                Purchase = sp.getString("PURCHASE", "");
                Loan = sp.getString("LOAN", "");
                Bankname = sp.getString("BANKNAME", "");
                Residantal = sp.getString("RESIDENTAL", "");
                Newspaper_Adv = sp.getString("NEWSPAPER_ADV", "");
                Newspaper_Insert = sp.getString("NEWSPAPER_INSERT", "");
                Hording = sp.getString("HORDINGS", "");
                Advertisement = sp.getString("DIGITAL_ADV", "");
                Telecalling = sp.getString("TELECALLING", "");
                Source = sp.getString("SOURCE", "");
                Broker = sp.getString("BROKER", "");
                Reference = sp.getString("REFERENCE", "");
                Log.d("ValueOfForm",""+FName+ LName+ Locality+ City+ Pincode+ Timetocall+ Phone+ Altphone+ Email+
                        Gender+ Status+ Occupation+ Company_name+ Designation+ Work_nature+ Business_location+
                        Configuration+ Specify+ Budget+ Loan+ Bankname+ Purchase+ Residantal+
                        Newspaper_Adv+ Newspaper_Insert+ Hording+Advertisement+ Telecalling+ Source+ Broker+ Reference);
//Insert Value in Database
                firestoredata();
//insert data
                Boolean checkValue = formDB.checkId(FormId);
                Log.d("CheckId",""+FormId);
                if (checkValue == true) {
                    Boolean updateFormData = formDB.UpdateFormData(FName, LName, Locality, City, Pincode, Timetocall, Phone, Altphone, Email,
                            Gender, Status, Occupation, Company_name, Designation, Work_nature, Business_location,
                            Configuration, Specify, Budget, Loan, Bankname, Purchase, Residantal,
                            Newspaper_Adv, Newspaper_Insert, Hording, Advertisement, Telecalling, Source, Broker, Reference);
                    if (updateFormData == true) {
                        UpdateDialog();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Details Are Not Updatted", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Boolean insertFormData = formDB.InsertFormData(FName, LName, Locality, City, Pincode, Timetocall, Phone, Altphone, Email,
                            Gender, Status, Occupation, Company_name, Designation, Work_nature, Business_location,
                            Configuration, Specify, Budget, Loan, Bankname, Purchase, Residantal,
                            Newspaper_Adv, Newspaper_Insert, Hording, Advertisement, Telecalling, Source, Broker, Reference);
                    if (insertFormData == true) {
                        SubmitDialog();
                    } else {
                        Toast.makeText(getApplicationContext(), "Details Are Not Submitted", Toast.LENGTH_LONG).show();
                    }
                        }
                    }
        });
    }

    //Firebase Value Store
    private void firestoredata() {
        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            dataModel.setId(cursor.getInt(0));
            dataModel.setFNAME(cursor.getString(1));
            dataModel.setLNAME(cursor.getString(2));
            dataModel.setLOCALITY(cursor.getString(3));
            dataModel.setCITY(cursor.getString(4));
            dataModel.setPINCODE(cursor.getInt(5));
            dataModel.setTIME_TO_CALL(cursor.getString(6));
            dataModel.setPHONE(cursor.getString(7));
            dataModel.setALTPHONE(cursor.getString(8));
            dataModel.setEMAIL(cursor.getString(9));
            //Personal Details
            dataModel.setGENDER(cursor.getString(10));
            dataModel.setSTATUS(cursor.getString(11));
            dataModel.setOCCUPATION(cursor.getString(12));
            dataModel.setCOMPANY_NAME(cursor.getString(13));
            dataModel.setDESIGNATION(cursor.getString(14));
            dataModel.setWORK_NATURE(cursor.getString(15));
            dataModel.setBUSINESS_LOCATION(cursor.getString(16));
            //Need And Requirment
            dataModel.setCONFIGURATION(cursor.getString(17));
            dataModel.setSPECIFY(cursor.getString(18));
            dataModel.setBUDGET(cursor.getString(19));
            dataModel.setLOAN(cursor.getString(20));
            dataModel.setBANKNAME(cursor.getString(21));
            dataModel.setPURCHASE(cursor.getString(22));
            dataModel.setRESIDENTAL(cursor.getString(23));
            //About Project
            dataModel.setNEWSPAPER_ADV(cursor.getString(24));
            dataModel.setNEWSPAPER_INSERT(cursor.getString(25));
            dataModel.setHORDING(cursor.getString(26));
            dataModel.setADVERTISEMENT(cursor.getString(27));
            dataModel.setTELECALLING(cursor.getString(28));
            dataModel.setSOURCE(cursor.getString(29));
            dataModel.setBROKER(cursor.getString(30));
            dataModel.setREFER(cursor.getString(31));
            dataView.add(dataModel);
        }
        dbreference.setValue(dataView);
    }
    //onBackPressedButton

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        //Bundle Data
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}