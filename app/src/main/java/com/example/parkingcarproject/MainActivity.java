package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgv;
    private Animation bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        },6000);
    }
    private void setup(){
        imgv=findViewById(R.id.car);
        bottom= AnimationUtils.loadAnimation(this,R.anim.buttom_animation);
        imgv.setAnimation(bottom);
    }
}