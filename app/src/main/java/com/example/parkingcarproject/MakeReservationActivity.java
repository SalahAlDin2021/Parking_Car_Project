package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.example.parkingcarproject.model.User;
import com.example.parkingcarproject.model.UserData;

public class MakeReservationActivity extends AppCompatActivity {

    EditText edtNumberOfHours;
    TextView totalPrice;
    Button reserve;
    int lotID;


    public static final String TOTAL_PRICE = "Total Price: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation);
        setUp();
        Intent it=getIntent();
        lotID=it.getIntExtra("lotid",-1);


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
                Toast.makeText(MakeReservationActivity.this,"you are reserve Lot number: "+lotID+",with price: "+
                        calculatePrice(Double.parseDouble(edtNumberOfHours.getText().toString())),Toast.LENGTH_LONG).show();
                User user =UserData.findUser(Integer.parseInt(MainActivity.id));
                Lot lot=LotData.search_lot(lotID);
                lot.setReserved(user,Double.parseDouble(edtNumberOfHours.getText().toString()));
                user.addLot(lot);
                Intent it=new Intent(MakeReservationActivity.this,UserLogedInScreenActivity.class);
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