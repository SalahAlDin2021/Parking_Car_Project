package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.parkingcarproject.model.Lot;
import com.example.parkingcarproject.model.LotData;

import java.util.ArrayList;


public class FindLotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_lot);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.my_recycler_view);
        Intent it=getIntent();
        int userId=it.getIntExtra("userId",-1);

        Log.d("iddd","findAlotActivity:"+userId);

        ArrayList<Lot> lots =LotData.lots;



        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(this,lots,userId);
        recycler.setAdapter(adapter);
    }
}