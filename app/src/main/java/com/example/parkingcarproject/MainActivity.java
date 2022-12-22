package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkingcarproject.model.LotData;
import com.example.parkingcarproject.model.UserData;

public class MainActivity extends AppCompatActivity {
    private ImageView imgv;
    private Animation bottom,top;
    private TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setup();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        },10000);
    }
    private void setup(){
        UserData u=new UserData();
        LotData L=new LotData();
        txtv=findViewById(R.id.textView);
        imgv=findViewById(R.id.car);
        bottom= AnimationUtils.loadAnimation(this,R.anim.buttom_animation);
        top= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        imgv.setAnimation(bottom);
        txtv.setAnimation(top);
    }
}