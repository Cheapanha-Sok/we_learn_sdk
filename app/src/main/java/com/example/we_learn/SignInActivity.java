package com.example.we_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


    }

    public void singIn (View view) {


        startActivity(new Intent(SignInActivity.this, MainActivity.class));
    }

    public void singUp (View view) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }
}