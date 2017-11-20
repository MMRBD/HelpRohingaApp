package com.example.mokle.helprohingaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DonationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
    }

    public void onClickMoney(View view){
        startActivity(new Intent(DonationActivity.this,SubmitActivity.class));

    }

    public void onCLickFood(View view){
        startActivity(new Intent(DonationActivity.this,SubmitActivity.class));

    }

    public void onClickMedicine(View view){
        startActivity(new Intent(DonationActivity.this,SubmitActivity.class));

    }

    public void onClickCloth(View view){
        startActivity(new Intent(DonationActivity.this,SubmitActivity.class));
    }

    public void onClickOthers(View view){
        startActivity(new Intent(DonationActivity.this,SubmitActivity.class));
    }
}
