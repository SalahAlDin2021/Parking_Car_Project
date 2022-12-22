package com.example.parkingcarproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingcarproject.model.UserData;

public class LoginScreenActivity extends AppCompatActivity{

    Button signupPage, forgetPassButton;
    ImageButton signin;
    EditText usernameEmail, password;
    String type="";
    TextView txtType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setup();
//        Log.d("typee",type);
        signupPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type=="user"){
                    Intent it = new Intent(LoginScreenActivity.this, SignUpActivity.class);
                    startActivity(it);
                }else{
                    Toast t = Toast.makeText(LoginScreenActivity.this, "you can't create admin account",
                            Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailobj = usernameEmail.getText().toString();
                String passobj = password.getText().toString();
                Log.d("informationnn","type:"+type+",,emai&pass:"+emailobj+","+passobj);
                if (emailobj.isEmpty()) {
                    usernameEmail.setError("Fill this field");
                    usernameEmail.setText("");
                }
                if(passobj.isEmpty()){
                    password.setError("Fill this field");
                    password.setText("");
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(emailobj).matches()) {
                    Toast t = Toast.makeText(LoginScreenActivity.this, "Invalid email address", Toast.LENGTH_LONG);
                    t.show();
                    usernameEmail.requestFocus();
                    return;
                }else{
                    //check email and password and change the activity to another activity if email and password matches
                    //at this moment will do this in bojo class
                    if(UserData.findUser(emailobj,passobj)>0 && type.equals("user")){
                        Toast toast = Toast.makeText(LoginScreenActivity.this, "Login successful", Toast.LENGTH_LONG);
                        toast.show();
                        Intent it = new Intent(LoginScreenActivity.this, UserLogedInScreenActivity.class);
                        it.putExtra("id",UserData.findUser(emailobj,passobj));
                        startActivity(it);
                        finish();

                    }else if(UserData.findUser(emailobj,passobj)>0 && type.equals("admin")){
                        Toast toast = Toast.makeText(LoginScreenActivity.this, "Login successful", Toast.LENGTH_LONG);
                        toast.show();
                        Intent it = new Intent(LoginScreenActivity.this, AdminLogedInScreenActivity.class);
                        it.putExtra("id",UserData.findUser(emailobj,passobj));
                        startActivity(it);
                        finish();
                    }else{
                        Toast t = Toast.makeText(LoginScreenActivity.this, "Authentication failed\nError :" +
                                " Email or Password are wrong", Toast.LENGTH_LONG);
                        t.show();
                    }



                }

            }
        });
        forgetPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LoginScreenActivity.this, ForgetPasswordActivity.class);
                startActivity(it);

            }
        });

    }

    void setup(){
        txtType=findViewById(R.id.type);
        usernameEmail = (EditText) findViewById(R.id.loginEmailID);
        password = (EditText) findViewById(R.id.loginpassID);

        signupPage = (Button) findViewById(R.id.signupPageID);

        signin = (ImageButton) findViewById(R.id.SigninID);

        forgetPassButton = (Button) findViewById(R.id.forgetPassID);
        Intent it=getIntent();
        type=it.getStringExtra("type");
        txtType.setText(type+" Login");
    }
}
