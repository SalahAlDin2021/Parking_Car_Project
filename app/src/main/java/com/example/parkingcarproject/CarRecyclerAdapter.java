package com.example.parkingcarproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingcarproject.model.CarDetails;
import com.example.parkingcarproject.model.Lot;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CarRecyclerAdapter extends RecyclerView.Adapter<CarRecyclerAdapter.CarViewHolder> {
    private Context context;
    private ArrayList<Lot> cars;

    public CarRecyclerAdapter(Context context, ArrayList<Lot> cars) {
        this.context = context;
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarRecyclerAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
       View v=inflater.inflate(R.layout.card_car_imageone,parent,true);
        return new CarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarRecyclerAdapter.CarViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(cars.get(position).isReserved()){
            holder.tv.setText("Available");
            holder.tv.setBackgroundColor(Color.parseColor("#0AB310"));
            holder.iv.setImageResource(R.drawable.car_2);
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent it=new Intent(context,ReservationActivity.class);
                    it.putExtra("carid",cars.get(position).getId());
                    context.startActivity(it);
                }
            });
        }else{
            holder.tv.setText("Not Available");
            holder.tv.setBackgroundColor(Color.parseColor("#FF0000"));
            holder.iv.setImageResource(R.drawable.car_2);
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"this Place was reserved",Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView iv;
        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            tv= itemView.findViewById(R.id.txtviewcardcar);
            iv=itemView.findViewById(R.id.carimage);
        }

    }
}
