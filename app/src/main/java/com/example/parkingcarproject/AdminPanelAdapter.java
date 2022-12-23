package com.example.parkingcarproject;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingcarproject.model.Lot;
import com.example.parkingcarproject.model.User;

import java.util.ArrayList;

public class AdminPanelAdapter
        extends RecyclerView.Adapter<AdminPanelAdapter.ViewHolder>{

    Context context;
    private ArrayList<User> users;
    public AdminPanelAdapter(Context context, ArrayList<User> users){
        this.users =users;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        holder.txt.setText(users.get(position).getUsername()+"");

        holder.cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    Intent it=new Intent(context,UserPageInAdminPanel.class);
                    it.putExtra("id",users.get(pos).getId());
                    context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        TextView txt;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
            txt=cardView.findViewById(R.id.txt_user_name);
        }

    }
}
