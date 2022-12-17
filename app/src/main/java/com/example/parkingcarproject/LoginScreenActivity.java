package com.example.parkingcarproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginScreenActivity extends Fragment implements View.OnClickListener{

    Button signupPage, forgetPassButton;
    ImageButton signin;
    EditText usernameEmail, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_login_screen, container, false);
        setup(v);

        return v;
    }
    void setup(View v){

        usernameEmail = (EditText) v.findViewById(R.id.loginEmailID);
        password = (EditText) v.findViewById(R.id.loginpassID);

        signupPage = (Button) v.findViewById(R.id.signupPageID);
        signupPage.setOnClickListener(this);

        signin = (ImageButton) v.findViewById(R.id.SigninID);
        signin.setOnClickListener(this);

        forgetPassButton = (Button) v.findViewById(R.id.forgetPassID);
        forgetPassButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String emailobj = usernameEmail.getText().toString();
        String passobj = password.getText().toString();

        if(v.getId()==R.id.signupPageID){
            Intent it = new Intent(getActivity(), SignUpActivity.class);
            startActivity(it);
        }

        if(v.getId()==R.id.SigninID){
            if (emailobj.isEmpty()) {
                usernameEmail.setError("Fill this field");
                usernameEmail.setText("");
            }
            if(passobj.isEmpty()){
                password.setError("Fill this field");
                password.setText("");
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(emailobj).matches()) {
                Toast t = Toast.makeText(getActivity(), "Invalid email address", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
                usernameEmail.requestFocus();
                return;
            }else{
                //check email and password and change the activity to another activity if email and password matches
                //at this moment will do this in bojo class
                if(emailobj=="email from bojo " && passobj=="pass from pojo"){
                    Toast toast = Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent it = new Intent(getActivity(), UserLogedInScreenActivity.class);
                    it.putExtra("id",emailobj+","+passobj);
                    startActivity(it);
                    getActivity().finish();

                }else{
                    Toast t = Toast.makeText(getActivity(), "Authentication failed\nError :" +
                                    " Email or Password are wrong", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }



            }
        }
    }
}
