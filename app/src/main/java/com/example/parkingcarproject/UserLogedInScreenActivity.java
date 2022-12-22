package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class UserLogedInScreenActivity extends AppCompatActivity {
    Button findAlot;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_loged_in_screen);
        findAlot=findViewById(R.id.find_alot);
        Intent it=getIntent();
        userId=it.getIntExtra("userId",-1);

        Log.d("iddd","userLogedIn:"+userId);

        findAlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(UserLogedInScreenActivity.this,FindLotActivity.class);
                it.putExtra("userId",userId);
                startActivity(it);
            }
        });


    }
}