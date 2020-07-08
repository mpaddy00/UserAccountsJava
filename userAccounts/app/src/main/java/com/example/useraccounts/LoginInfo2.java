package com.example.useraccounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginInfo2 extends AppCompatActivity {
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_info2);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        initLoginButton();
        initMainButton();
        initLogButton();
    }
    public String getUser(){
        String string = prefs.getString("Yourkey","user");
        return string;
    }
    public String getPassword(){
        String string2 = prefs.getString("Yourkey","password");
        return string2;
    }
    private void initMainButton()
    {
        ImageButton ibMain = findViewById(R.id.buttonMain);
        ibMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initLoginButton(){
        ImageButton ibMain = findViewById(R.id.buttonLogin);
        ibMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, LoginInfo2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
    public String getTextLog(){
        EditText eddit= findViewById(R.id.Login);
        String s = eddit.getText().toString();
        return s;
    }
    public String getTextP(){
        EditText eddit= findViewById(R.id.password);
        String s2 = eddit.getText().toString();
        return s2;
    }
    public void initLogButton(){
        if(getTextP().equals(getTextLog())&&getPassword().equals(getTextP())){
            toast.makeText("login succesfull");
        }else{
            toast.makeText("login unsuccesfull");
        }
    }

}

