package com.example.salesenquiry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import android.widget.*;

import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class welcome extends AppCompatActivity {
    SliderView sliderView;
    int[] images = {R.drawable.a,
            R.drawable.b,
            R.drawable.c};
    Button enquiry;
    SliderAdapter sliderAdapter;
    TextView description, permia_txt, nexttxt;
    Button sales_data;
    ImageView permia_logo, kenarc_logo, kenarc_txt;
    Toolbar toolbar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        permia_logo = findViewById(R.id.premia_logo);
        permia_txt = findViewById(R.id.premia_text);
        kenarc_logo = findViewById(R.id.kenarc_logo);
        //  kenarc_txt=findViewById(R.id.kenarc_logo);
        nexttxt = findViewById(R.id.nextTxt);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menubar);
        firebaseAuth = FirebaseAuth.getInstance();
        sliderView = findViewById(R.id.image_slider);
        sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        //Enquiry Button
        enquirybut();
//menubar

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.data:
                startActivity(new Intent(getApplicationContext(), com.example.salesenquiry.EnquiryFrom.view_form_data.class));
                break;
            case R.id.aboutus:
                Toast.makeText(getApplicationContext(), "About Us", Toast.LENGTH_LONG).show();
                break;
            case R.id.contactus:
                Toast.makeText(getApplicationContext(), "Contact Us", Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                firebaseAuth.signOut();
                Toast.makeText(this, "Log Out Sucessful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), login.class));
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    //Open Sales Enquiry Form
    private void enquirybut() {
        nexttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open Form Activity
                Intent intent = new Intent(getApplicationContext(), com.example.salesenquiry.EnquiryFrom.personal.class);
                startActivity(intent);
                finish();
            }
        });
    }

}