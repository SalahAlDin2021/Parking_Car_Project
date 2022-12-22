package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkingcarproject.model.Lot;
import com.example.parkingcarproject.model.LotData;
import com.example.parkingcarproject.model.UserData;

public class CarInfoActivity extends AppCompatActivity {

    EditText edtNumberOfHours;
    TextView totalPrice;
    Button reserve;
    int lotID,userId;


    public static final String TOTAL_PRICE = "Total Price: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
        setUp();
        Intent it=getIntent();
        lotID=it.getIntExtra("carid",-1);
        userId=it.getIntExtra("userId",-1);
        Log.d("iddd","CarInfo:"+lotID+",,,"+userId);


        edtNumberOfHours.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    totalPrice.setText(TOTAL_PRICE+calculatePrice(Double.parseDouble(edtNumberOfHours.getText().toString())));

                    return true;
                }
                return false;
            }

        });


        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarInfoActivity.this,"you are reserve Lot number: "+lotID+",with price: "+
                        calculatePrice(Double.parseDouble(edtNumberOfHours.getText().toString())),Toast.LENGTH_LONG).show();
                UserData.findUser(userId).addLot(LotData.search_lot(lotID));
                LotData.lots.get(lotID).setReserved(UserData.findUser(userId),Double.parseDouble(edtNumberOfHours.getText().toString()));
                Intent it=new Intent(CarInfoActivity.this,UserLogedInScreenActivity.class);
                it.putExtra("userId",userId);
                startActivity(it);
                finish();
            }
        });
    }

    void setUp(){
        edtNumberOfHours = findViewById(R.id.editTextNumberOfHours);
        totalPrice = findViewById(R.id.txtTotalPrice);
        reserve=findViewById(R.id.btnReserve);
    }
    Double calculatePrice(double hours){
        return hours*Lot.PRICE_PER_HOUR;
    }

}