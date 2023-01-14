package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.TextView;

import com.example.parkingcarproject.model.User;
import com.example.parkingcarproject.model.UserData;

public class ProfileActivity extends AppCompatActivity {

    private TextView mEmailTextView;
    private TextView mPasswordTextView;
    private TextView mIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mEmailTextView = findViewById(R.id.email_text_view);
        mPasswordTextView = findViewById(R.id.password_text_view);
        mIdTextView = findViewById(R.id.id);
        mEmailTextView.setText("Email: "+MainActivity.email);
        mPasswordTextView.setText("Password: "+MainActivity.password);
        mIdTextView.setText("ID: "+MainActivity.id);
    }

}
