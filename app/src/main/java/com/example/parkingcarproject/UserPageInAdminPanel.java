package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkingcarproject.model.User;
import com.example.parkingcarproject.model.UserData;

public class UserPageInAdminPanel extends AppCompatActivity {
    TextView id,pay_to_be_paid;
    EditText username,email,password,pay_amount;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page_in_admin_panel);
        Intent it=getIntent();
        int id=it.getIntExtra("id",-1);
        User user= UserData.findUser(id);
        setup(user);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String err_msg="";
                boolean correct=true;
                if(username.getText().toString().isEmpty()){
                    err_msg+="please enter a correct username, ";correct=false;
                }if(email.getText().toString().isEmpty() && !email.getText().toString().contains("@")){
                    err_msg+="please enter a correct email, ";correct=false;
                }if(password.getText().toString().isEmpty() && password.getText().toString().length()<7){
                    err_msg+="please enter a correct password(more than 7 chars), ";correct=false;
                }
                if(correct){
                    user.setUsername(username.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassword(password.getText().toString());
                    if(!pay_amount.getText().toString().isEmpty()){
                        user.addPayAmount(Double.parseDouble(pay_amount.getText().toString()));
                    }
                    Intent it=new Intent(UserPageInAdminPanel.this,AdminLogedInScreenActivity.class);
                    startActivity(it);
                    finish();
                }else{
                    Toast.makeText(UserPageInAdminPanel.this,err_msg,Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    private void setup(User user){
        id=findViewById(R.id.txt_user_id);

        Log.d("userr",user.toString());
        Log.d("userr",user.toString());
        Log.d("userr",user.toString());


        id.setText(""+user.getId());
        pay_to_be_paid=findViewById(R.id.txt_user_amount_to_be_paid);
        pay_to_be_paid.setText(""+(user.calculate_price_of_lots()-user.getPayAmount()));
        username=findViewById(R.id.edt_user_name);
        username.setText(user.getUsername());
        email=findViewById(R.id.edt_user_email);
        email.setText(user.getEmail());
        password=findViewById(R.id.edt_user_password);
        password.setText(user.getPassword());
        pay_amount=findViewById(R.id.edt_user_pay_amount);
        btnEdit=findViewById(R.id.btn_edit);
    }
}