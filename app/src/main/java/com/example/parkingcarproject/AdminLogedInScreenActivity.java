package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.parkingcarproject.model.Lot;
import com.example.parkingcarproject.model.LotData;
import com.example.parkingcarproject.model.User;
import com.example.parkingcarproject.model.UserData;

import java.util.ArrayList;

public class AdminLogedInScreenActivity extends AppCompatActivity {
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_loged_in_screen);

        recycler = (RecyclerView)findViewById(R.id.rv_admin_panel);

        ArrayList<User> users = UserData.users;
        recycler.setLayoutManager(new LinearLayoutManager(this));
        AdminPanelAdapter adapter = new AdminPanelAdapter(this,users);
        recycler.setAdapter(adapter);
    }
}