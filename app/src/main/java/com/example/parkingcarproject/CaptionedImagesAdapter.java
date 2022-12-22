package com.example.parkingcarproject;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingcarproject.model.Lot;

import java.util.ArrayList;

public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{

    Context context;
    int userId;
    private ArrayList<Lot> lots;
    public static final String AVAILABLE ="Available";
    public static final String UN_AVAILABLE ="UnAvailable";
    public CaptionedImagesAdapter(Context context, ArrayList<Lot> lots, int userId){
       this.lots=lots;
       this.context=context;
       this.userId=userId;
        Log.d("iddd","adapter:"+userId);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_car,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;



        if(lots.get(position).isReserved()) {
            holder.txtStatus.setText("Status: " +AVAILABLE);
            holder.txtStatus.setTextColor(Color.GREEN);
        }else {
            holder.txtStatus.setText("Status: " +UN_AVAILABLE);
            holder.txtStatus.setTextColor(Color.RED);
        }
        holder.txt.setText(lots.get(position).getId()+"");

        holder.cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!lots.get(pos).isReserved()){
                    Toast.makeText(context,"Sorry, This Lot has been Reserved" ,Toast.LENGTH_LONG).show();
                }else{

                    Log.d("iddd","adapter:"+lots.get(pos)+",,,"+userId);
                    Intent it=new Intent(context,MakeReservationActivity.class);
                    it.putExtra("lotId",lots.get(pos).getId());
                    it.putExtra("userId",userId);
                    context.startActivity(it);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lots.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        TextView txtStatus ;
        TextView txt;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
            txtStatus=cardView.findViewById(R.id.txtStatusID);
            txt=cardView.findViewById(R.id.txtViewCardCar);
        }

    }
}
