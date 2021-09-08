package com.example.salesenquiry.EnquiryFrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salesenquiry.R;
import com.google.android.material.textfield.TextInputEditText;

import java.time.temporal.TemporalAdjusters;

import static android.content.ContentValues.TAG;

public class need_require extends AppCompatActivity {
    Spinner budget;
    TextView next, previous,configurationtxt,budgettxt,purchasetxt, HomeLoan, Residantial,needtxt;
    EditText specify;
    TextInputEditText BankName;
    CheckBox one, two, three, other;
    RadioGroup getLoan, getResident, getPurchase;
    RadioButton getLoanval, getResidentval, getPurchaseval,self_fund,housing_loan,approve,no_approve,owned,rent;
    String budgets[] = {"< 1Cr.", "1.0 - 1.25 Cr", "1.25 – 1.5 Cr", "1.5 – 2 Cr", "2 cr & above"};
    String clientbudget=" ";
    String Residentalval=" ",Loanval=" ",Purchaseval =" ", configurationval=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_require);
        needtxt=findViewById(R.id.needtxt);
        configurationtxt=findViewById(R.id.configrationtxt);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        other = findViewById(R.id.other);
        specify = findViewById(R.id.specify);
        budgettxt=findViewById(R.id.budgettxt);
        budget = findViewById(R.id.spinner);
        purchasetxt=findViewById(R.id.purchasetxt);
        self_fund=findViewById(R.id.self_fund);
        housing_loan=findViewById(R.id.housing_loan);
        approve=findViewById(R.id.approve);
        no_approve=findViewById(R.id.noapprove);
        HomeLoan = findViewById(R.id.loan);
        Residantial = findViewById(R.id.residental);
        owned= findViewById(R.id.owned);
        rent=findViewById(R.id.rent);
        BankName = findViewById(R.id.bankname);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        getPurchase=findViewById(R.id.purchaseval);
        getLoan = findViewById(R.id.loangroup);
        getResident = findViewById(R.id.typegroup);
        buttonclick();
        //Configuration Value
        configurationbox();
        //budget value
        budgetitem();
        //purchase value
        purchaseVal();
        //get Home Value
        loangrouptxt();
        //Residental Type
        typegrouptxt();
//        //Update Data
          UpdateFormData();

    }

//    //Update Form Data
    private void UpdateFormData() {
        specify.setText(getIntent().getStringExtra("SPECIFY"));
        BankName.setText(getIntent().getStringExtra("BANKNAME"));
        Residentalval=getIntent().getStringExtra("RESIDENTAL");
    }

    //Configuration
    private void configurationbox() {
        one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (one.isChecked()) {
                    configurationval +=" "+one.getText().toString();
                }
            }
        });
        two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (two.isChecked()) {
                    configurationval +=" " +two.getText().toString();
                }
            }
        });
        three.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (three.isChecked()) {
                configurationval +=" "+three.getText().toString();
                }
            }
        });
        other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (other.isChecked()) {
                    configurationval +=other.getText().toString();
                }
            }
        });
    }

    //Budget value
    private void budgetitem() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.budget_item, budgets);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        budget.setAdapter(arrayAdapter);
        budget.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                clientbudget = (budgets[position].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                clientbudget = "Null";
            }
        });
    }

    //Get purchase value
    private void purchaseVal() {
        getPurchase.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.self_fund == checkedId){
                    Purchaseval +=" "+self_fund.getText().toString();
                }
                else if (R.id.housing_loan == checkedId){
                    Purchaseval +=" "+housing_loan.getText().toString();
                }
            }
        });
    }

    //Home Loan
    private void loangrouptxt() {
//        int selectedLoanId=getPurchase.getCheckedRadioButtonId();
//        if (selectedLoanId != -1) {
//            getLoanval = findViewById(selectedLoanId);
//            Loanval +=getLoanval.getText().toString();
//        }
//        else{
//
//        }
        getLoan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.approve == checkedId){
                    Loanval +=" "+approve.getText().toString();
                }
                else if (R.id.noapprove == checkedId){
                    Loanval +=" "+no_approve.getText().toString();
                }
                else{
                    Loanval +="Null";
                }
            }
        });
    }

    //Current Residental Type
    private void typegrouptxt() {
//        int selectedResidentalId=getResident.getCheckedRadioButtonId();
//        if (selectedResidentalId != -1) {
//            getResidentval = findViewById(selectedResidentalId);
//            Residentalval +=getResidentval.getText().toString();
//        }
        getResident.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.owned == checkedId){
                    Residentalval +=" "+owned.getText().toString();
                }
                else if (R.id.rent == checkedId){
                    Residentalval +=" "+rent.getText().toString();
                }
                else{
                    Residentalval +="Null";
                }
            }
        });
    }

    //Next Previous
    private void buttonclick() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("DetailsKey", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                try {
                    ed.putString("CONFIGURATION", configurationval);
                    ed.putString("SPECIFY", specify.getText().toString());
                    ed.putString("BUDGETS", clientbudget);
                    ed.putString("PURCHASE", Purchaseval);
                    ed.putString("LOAN",Loanval);
                    ed.putString("BANKNAME", BankName.getText().toString());
                    ed.putString("RESIDENTAL", Residentalval);
                    ed.apply();
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }

                Intent intent = new Intent(getApplicationContext(), about_project.class);
                //about project
                intent.putExtra("ID",getIntent().getIntExtra("ID",0));
                intent.putExtra("NEWSPAPER",getIntent().getStringExtra("NEWSPAPER"));
                intent.putExtra("ENTER_NEWSPAPER",getIntent().getStringExtra("ENTER_NEWSPAPER"));
                intent.putExtra("HORDING",getIntent().getStringExtra("HORDING"));
                intent.putExtra("ADVERTISMENT",getIntent().getStringExtra("ADVERTISMENT"));
                intent.putExtra("SOURCE",getIntent().getStringExtra("SOURCE"));
                intent.putExtra("TELECALLING",getIntent().getStringExtra("TELECALLING"));
                intent.putExtra("REFER",getIntent().getStringExtra("REFER"));
                intent.putExtra("PARTNER",getIntent().getStringExtra("PARTNER"));
                startActivity(intent);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent2=new Intent(getApplicationContext(), personal_2.class);
                intent2.putExtra("GENDER",getIntent().getStringExtra("GENDER"));
                intent2.putExtra("STATUS",getIntent().getStringExtra("STATUS"));
                intent2.putExtra("OCCUPATION",getIntent().getStringExtra("OCCUPATION"));
                intent2.putExtra("COMPANY_NAME",getIntent().getStringExtra("COMPANY_NAME"));
                intent2.putExtra("DESIGNATION",getIntent().getStringExtra("DESIGNATION"));
                intent2.putExtra("WORK_NATURE",getIntent().getStringExtra("WORK_NATURE"));
                intent2.putExtra("BUSINESS_LOCATION",getIntent().getStringExtra("BUSINESS_LOCATION"));
                startActivity(intent2);
            }
        });
    }

}