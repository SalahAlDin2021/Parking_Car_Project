package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.parkingcarproject.model.Lot;
import com.example.parkingcarproject.model.LotData;
import com.example.parkingcarproject.model.User;
import com.example.parkingcarproject.model.UserData;

import java.util.ArrayList;

public class AdminLogedInScreenActivity extends AppCompatActivity {
    RecyclerView recycler;
    Button btnLogout;

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
        setContentView(R.layout.activity_admin_loged_in_screen);
        setUpShard();

        recycler = (RecyclerView)findViewById(R.id.rv_admin_panel);
        btnLogout=findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                Intent it=new Intent(AdminLogedInScreenActivity.this,MenuActivity.class);
                startActivity(it);
                finish();
            }
        });
        ArrayList<User> users = UserData.users;
        recycler.setLayoutManager(new LinearLayoutManager(this));
        AdminPanelAdapter adapter = new AdminPanelAdapter(this,users);
        recycler.setAdapter(adapter);
    }

    private void setUpShard(){
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor= pref.edit();
    }
}