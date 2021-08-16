package com.example.salesenquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class welcome extends AppCompatActivity {
SliderView sliderView;
int[] images={R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e};
    Button enquiry;
SliderAdapter sliderAdapter;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        enquiry=findViewById(R.id.enquirybut);
      sliderView=findViewById(R.id.image_slider);
        sliderAdapter=new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        //Enquiry Button
    enquirybut();

    }
//Open Sales Enquiry Form
    private void enquirybut() {
enquiry.setOnClickListener(new View.OnClickListener() {
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