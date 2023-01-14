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
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_lot);

        recycler = (RecyclerView)findViewById(R.id.my_recycler_view);

        ArrayList<Lot> lots =LotData.lots;
        Log.d("messi",lots.toString());
        for(Lot lot:lots){
            lot.checkifEnd();
        }
        Log.d("messi",lots.toString());
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(this,lots);
        recycler.setAdapter(adapter);
    }
}