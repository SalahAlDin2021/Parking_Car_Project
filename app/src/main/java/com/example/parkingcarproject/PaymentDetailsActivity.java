package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parkingcarproject.model.Lot;
import com.example.parkingcarproject.model.User;
import com.example.parkingcarproject.model.UserData;

import java.util.ArrayList;

public class PaymentDetailsActivity extends AppCompatActivity {

    private TextView txtTotalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        txtTotalPayment=findViewById(R.id.textViewTotalPayment);
        User user=UserData.findUser(Integer.parseInt(MainActivity.id));
        Double result = totalPayment(user);
        txtTotalPayment.setText("you should pay: " + result.toString());

    }


    public double totalPayment(User user){
        Double totalPrice = 0.0;
        ArrayList<Lot> lots=user.getLots();
        for(int i=0;i<lots.size();i++){
            totalPrice+=lots.get(i).getPrice();
        }
        totalPrice-=user.getPayAmount();
        return totalPrice;
    }

}