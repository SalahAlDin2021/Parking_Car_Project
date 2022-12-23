package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class UserLogedInScreenActivity extends AppCompatActivity {
    Button findAlot , btnPaymentDetails ,btnAbout ,  btnFeedBack ,btnProfile;
    int userId;
    private boolean savedIns = false;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    public static final String ID = "ID";
    public static final String TYPE = "TYPE";
    public static final boolean FLAG = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_loged_in_screen);
        setUp();

        findAlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(UserLogedInScreenActivity.this,FindLotActivity.class);
                it.putExtra("userId",userId);
                startActivity(it);
            }
        });
        btnPaymentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogedInScreenActivity.this , PaymentDetailsActivity.class);
                intent.putExtra("userId" ,userId);
                startActivity(intent);
            }
        });

         btnAbout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(UserLogedInScreenActivity.this , AbuotActivity.class);
                 startActivity(intent);
             }
         });

        btnFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogedInScreenActivity.this , FeedbackActivity.class);
                startActivity(intent);
            }
        });

       btnProfile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(UserLogedInScreenActivity.this , ProfileActivity.class);
               intent.putExtra("userId" ,userId);
               startActivity(intent);
           }
       });


    }

    public void setUp(){
        findAlot=findViewById(R.id.find_alot);
        btnPaymentDetails = findViewById(R.id.btnPaymentDetails);
        btnAbout = findViewById(R.id.btnAbout);
        btnFeedBack = findViewById(R.id.btnFeedBack);
        btnProfile= findViewById(R.id.btnProfile);
    }
}