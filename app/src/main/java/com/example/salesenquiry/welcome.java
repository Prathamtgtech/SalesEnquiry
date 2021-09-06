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

import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class welcome extends AppCompatActivity {
SliderView sliderView;
int[] images={R.drawable.a,
        R.drawable.b,
        R.drawable.c};
    Button enquiry;
SliderAdapter sliderAdapter;
TextView description,permia_txt,nexttxt;
Button sales_data;
ImageView permia_logo,kenarc_logo,kenarc_txt;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
       permia_logo=findViewById(R.id.premia_logo);
    permia_txt=findViewById(R.id.premia_text);
    kenarc_logo=findViewById(R.id.kenarc_logo);
  //  kenarc_txt=findViewById(R.id.kenarc_logo);
    nexttxt=findViewById(R.id.nextTxt);
      sliderView=findViewById(R.id.image_slider);
        sliderAdapter=new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
//        sales_data=findViewById(R.id.view_data);
//        sales_data.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),com.example.salesenquiry.EnquiryFrom.view_form_data.class));
//            }
//        });
        sliderView.startAutoCycle();
        //Enquiry Button
    enquirybut();
//menubar
    }


    //Open Sales Enquiry Form
    private void enquirybut() {
nexttxt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Open Form Activity
        Intent intent=new Intent(getApplicationContext(),com.example.salesenquiry.EnquiryFrom.personal.class);
        startActivity(intent);
        finish();
    }
});
}

}