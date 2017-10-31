package com.example.mokle.helprohingaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFastAid(View view){
        startActivity(new Intent(this,FastAidActivity.class));
    }

    public void onClickEmergencyService(View view){
        startActivity(new Intent(this,EmergencyServiceActivity.class));
    }

    public void onClickSafetyPlace(View view){
        startActivity(new Intent(this,SafetyPlaceActivity.class));
    }

    public void onClickLiveVideo(View view){
        startActivity(new Intent(this,LiveVideoActivity.class));
    }

    public void onClickAbout(View view){
        startActivity(new Intent(this,AboutActivity.class));
    }
}
