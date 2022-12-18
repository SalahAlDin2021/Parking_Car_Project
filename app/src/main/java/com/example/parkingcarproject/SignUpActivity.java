package com.example.parkingcarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    Button signinPage;
    ImageButton signup;
    EditText Editemail, Editpass, confirmpass, usernm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setup();
        signinPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = Editemail.getText().toString().trim();
                String Username = usernm.getText().toString().trim();
                String Password = Editpass.getText().toString().trim();
                String ConfirmPassword = confirmpass.getText().toString().trim();
                if(Email.isEmpty()) {
                    Editemail.setError("Fill this field");
                    Editemail.setText("");
                }
                if(Username.isEmpty()) {
                    usernm.setError("Fill this field");
                    usernm.setText("");
                }
                if(Password.isEmpty()) {
                    Editpass.setError("Fill this field");
                    Editpass.setText("");
                }
                if(ConfirmPassword.isEmpty()) {
                    confirmpass.setError("Fill this field");
                    confirmpass.setText("");
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    Toast t = Toast.makeText(SignUpActivity.this, "Invalid email address", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }

                if (Password.length() < 8) {
                    Editpass.setError("Password is too short.\nPassword must contain minimum 8 characters");
                    Editpass.setText("");
                    confirmpass.setText("");
                }

                if ((Password.length() >= 8) && (Password.matches(ConfirmPassword))) {
                    //add the user to database, which will implemented in phase2

                }else {
                    Toast toast = Toast.makeText(SignUpActivity.this, "Password did not match", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Editemail.requestFocus();
                    Editpass.requestFocus();
                }

            }
        });

    }
    private void setup(){
        signinPage = findViewById(R.id.signInPageID);
        signup =findViewById(R.id.SignupID);
        Editemail = findViewById(R.id.signupEmailID);
        usernm = findViewById(R.id.signupUsernameID);
        Editpass = findViewById(R.id.signupPasswordID);
        confirmpass = findViewById(R.id.confirmPasswordID);
    }
}