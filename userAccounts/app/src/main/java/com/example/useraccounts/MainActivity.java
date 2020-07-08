package com.example.useraccounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    String user;
    String password;
    String fullname;
    SharedPreferences.Editor edit;
    private SharedPreferences prefs;
    private final String pRef = "prefs";
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs= this.getSharedPreferences("com.example.useraccounts",
                Context.MODE_PRIVATE);
        initMainButton();
        initLoginButton();
        initTextChangedEvents();
        initSaveButton();

        Bundle extras = getIntent().getExtras();
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
    private void initTextChangedEvents() {
        final EditText userName = findViewById(R.id.editUser);
        userName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                user = userName.getText().toString();
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                //  Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //  Auto-generated method stub
            }
        });

        final EditText passwort = findViewById(R.id.editPass);
        passwort.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                password = passwort.getText().toString();
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                //  Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //  Auto-generated method stub
            }
        });

        final EditText editFull = findViewById(R.id.editFull);
        editFull.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            public void afterTextChanged(Editable editable) {
                fullname = editFull.getText().toString();
            }
        });
    }

        public void initSaveButton(){
            Button saveB = findViewById(R.id.saveButton);
            saveB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("Yourkey", user+"");
                        editor.putString("Yourkey", password+"");
                        editor.putString("Yourkey", fullname+"");
                        editor.commit();
                    }

                                     }

            );
        }

}
