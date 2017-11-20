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
        startActivity(new Intent(this,SafetyPlaceMapsActivity.class));
    }

    public void onClickLiveVideo(View view){
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);

    }
    public void onClickAbout(View view){
        startActivity(new Intent(this,AboutActivity.class));
    }
    public void onClickDonate(View view){
        startActivity(new Intent(this,DonationActivity.class));
    }


}
