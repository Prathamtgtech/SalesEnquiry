package com.example.salesenquiry.EnquiryFrom;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.salesenquiry.Database.FormDB;
import com.example.salesenquiry.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class View_form extends AppCompatActivity {
    TextView name, fname,lname, locality, locality_1, city, city_1, pincode, pincode_1, time_to_call, time_to_call_1, phone, phone_1, alt_phone,
            alt_phone_1, email_id, email_id_1, gender,gender_1,status,status_1, occupation, occupation_1, designation,designations_1,business_loc, business_loc_1, company_name,
            company_name_1, work_nature_, work_nature_1, configuration, configutation_1, specify, specify_1, budgets, budgets_1, loan, loan_1,
            bank_name, bank_name_1, purchase, purchase_1, residental, residental_1, newspapers_adv, newspapersadv_1,newspapersinsert,newspaperinsert_1,
            hording, hording_1, sources, sources_1, advertisement, advertisment_1, telecalling, telecalling_1,broker,broker_1, refer, refers_1;
    Cursor cursor;
    ArrayList<DataModel> dataView=new ArrayList<DataModel>();
    DataModel dataModel;
    FirebaseDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form);
        //Personal Details
        name = findViewById(R.id.name);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        locality = findViewById(R.id.locality);
        locality_1 = findViewById(R.id.locality_1);
        city = findViewById(R.id.city);
        city_1 = findViewById(R.id.city_1);
        pincode = findViewById(R.id.pincode);
        pincode_1 = findViewById(R.id.pincode_1);
        time_to_call = findViewById(R.id.timetocalls);
        time_to_call_1 = findViewById(R.id.timetocalls_1);
        phone = findViewById(R.id.phone);
        phone_1 = findViewById(R.id.phone_1);
        alt_phone = findViewById(R.id.alt_phone);
        alt_phone_1 = findViewById(R.id.alt_phone_1);
        email_id = findViewById(R.id.email_id);
        email_id_1 = findViewById(R.id.email_id_1);
        gender=findViewById(R.id.gender);
        gender_1=findViewById(R.id.gender_1);
        status=findViewById(R.id.status);
        status_1=findViewById(R.id.status_1);
        occupation=findViewById(R.id.occupation);
        occupation_1=findViewById(R.id.occupation_1);
        designation=findViewById(R.id.designations);
        designations_1=findViewById(R.id.designations_1);
        business_loc=findViewById(R.id.busiloc);
        business_loc_1=findViewById(R.id.business_loc_1);
        company_name=findViewById(R.id.company_name);
        company_name_1=findViewById(R.id.company_name_1);
        work_nature_=findViewById(R.id.nature_work);
        work_nature_1=findViewById(R.id.nature_work_1);
//need and requirements
        configuration=findViewById(R.id.configuration);
        configutation_1=findViewById(R.id.configration_1);
        specify=findViewById(R.id.specifys);
        specify_1=findViewById(R.id.specifys_1);
        budgets=findViewById(R.id.budgets);
        budgets_1=findViewById(R.id.budgets_1);
        loan=findViewById(R.id.loans);
        loan_1=findViewById(R.id.loans_1);
        bank_name=findViewById(R.id.bank_name);
        bank_name_1=findViewById(R.id.bank_name_1);
        purchase=findViewById(R.id.purchases);
        purchase_1=findViewById(R.id.purchases_1);
        residental=findViewById(R.id.residentals);
        residental_1=findViewById(R.id.residentals_1);

        //About Project
        newspapers_adv=findViewById(R.id.newspapers);
        newspapersadv_1=findViewById(R.id.newspapers_1);
        newspapersinsert=findViewById(R.id.enter_newpapers);
        newspaperinsert_1=findViewById(R.id.enter_newpapers_1);
        hording=findViewById(R.id.hordings);
        hording_1=findViewById(R.id.hordings_1);
        sources=findViewById(R.id.sources);
        sources_1=findViewById(R.id.sources_1);
        advertisement=findViewById(R.id.advertisements);
        advertisment_1=findViewById(R.id.advertisements_1);
        telecalling=findViewById(R.id.telecallings);
        telecalling_1=findViewById(R.id.telecallings_1);
        broker=findViewById(R.id.brokers);
        broker_1=findViewById(R.id.brokers_1);
        refer=findViewById(R.id.references);
        refers_1=findViewById(R.id.references_1);
        cursor=new FormDB(this).FetchCustData();
        getTheData();
    }

    private void getTheData() {
        while (cursor.moveToNext()){
            //Personal Details
            fname.setText(cursor.getString(1));
            lname.setText(cursor.getString(2));
            locality_1.setText(cursor.getString(3));
            city_1.setText(cursor.getString(4));
            pincode_1.setText(cursor.getString(5));
            time_to_call_1.setText(cursor.getString(6));
            phone_1.setText(cursor.getString(7));
            alt_phone_1.setText(cursor.getString(8));
            email_id_1.setText(cursor.getString(9));
            gender_1.setText(cursor.getString(10));
            status_1.setText(cursor.getString(11));
            occupation_1.setText(cursor.getString(12));
            company_name_1.setText(cursor.getString(13));
            designations_1.setText(cursor.getString(14));
            work_nature_1.setText(cursor.getString(15));
            business_loc_1.setText(cursor.getString(16));
            //Need And Requirement
            configutation_1.setText(cursor.getString(17)+cursor.getString(18)+cursor.getString(19)+cursor.getString(20));
            specify_1.setText(cursor.getString(21));
            budgets_1.setText(cursor.getString(22));
            loan_1.setText(cursor.getString(23));
            bank_name_1.setText(cursor.getString(24));
            purchase_1.setText(cursor.getString(25));
            residental_1.setText(cursor.getString(26));
            //about project
            newspapersadv_1.setText(cursor.getString(27));
            newspaperinsert_1.setText(cursor.getString(28));
            hording_1.setText(cursor.getString(29));
            advertisment_1.setText(cursor.getString(30));
            telecalling_1.setText(cursor.getString(31));
            sources_1.setText(cursor.getString(32));
            broker_1.setText(cursor.getString(33));
            refers_1.setText(cursor.getString(34));
        }
    }

}