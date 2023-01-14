package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkingcarproject.model.AdminData;
import com.example.parkingcarproject.model.LotData;
import com.example.parkingcarproject.model.UserData;

public class MainActivity extends AppCompatActivity {
    private ImageView imgv;
    private Animation bottom,top;
    private TextView txtv;
    public static String id="",type="",email="",password="";


    private boolean savedIns = false;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    public static final String ID = "ID";
    public static final String TYPE = "TYPE";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final boolean FLAG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setup();
        setUpShard();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean f = pref.getBoolean("FLAG" , false);
                if(f){
                     id = pref.getString(ID,"");
                    type = pref.getString(TYPE,"");
                    email = pref.getString(EMAIL,"");
                    password = pref.getString(PASSWORD,"");
                }
                if(!id.isEmpty()){
                    if(type.equals("user")){
                        Intent intent = new Intent(MainActivity.this, UserLogedInScreenActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent = new Intent(MainActivity.this, AdminLogedInScreenActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }else {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },10000);
    }
    private void setup(){
        UserData u=new UserData();
        AdminData d=new AdminData();
        LotData L=new LotData();
        txtv=findViewById(R.id.textView);
        imgv=findViewById(R.id.car);
        bottom= AnimationUtils.loadAnimation(this,R.anim.buttom_animation);
        top= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        imgv.setAnimation(bottom);
        txtv.setAnimation(top);
    }
    private void setUpShard(){
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor= pref.edit();
    }
}