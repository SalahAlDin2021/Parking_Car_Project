package com.example.parkingcarproject;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener{

    RadioGroup radioButtonGroup;
    RadioButton resultRadioButton;
    Button send;
    EditText feedback;
    int selectedID;
    String message, username;

    @Override
    public void onCreate ( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setup();

    }

    private void setup(){

        feedback = findViewById(R.id.feedbackID);
        radioButtonGroup = findViewById(R.id.radiogroupID);
        send = findViewById(R.id.sendID);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sendID){
            String comment = feedback.getText().toString();

            if(comment.isEmpty()) {
                feedback.setError("Fill this field");
            }

            else {
                selectedID = radioButtonGroup.getCheckedRadioButtonId();
                resultRadioButton = (RadioButton) radioButtonGroup.findViewById(selectedID);
                message = resultRadioButton.getText().toString();
                //the code to save the user feedback to database, so will coming in phase 2
                feedback.setText(null);
            }
        }

    }
}
