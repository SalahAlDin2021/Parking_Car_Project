package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.parkingcarproject.model.CarDetails;
import com.example.parkingcarproject.model.Lot;

import java.util.ArrayList;

public class FindLotActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_lot);
        ArrayList<Lot> list=new ArrayList<Lot>();
        list.add(new Lot(1,true));
        list.add(new Lot(2,false));
        list.add(new Lot(3,false));
        list.add(new Lot(4,false));
        list.add(new Lot(5,true));
        list.add(new Lot(6,true));
        list.add(new Lot(7,false));
        list.add(new Lot(8,false));
//        var list:MutableList<String> = intent?.extras?.get("post").toString().split(",") as MutableList<String>
        Log.d("rvv","in");
        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CarRecyclerAdapter(this,list));

    }
}