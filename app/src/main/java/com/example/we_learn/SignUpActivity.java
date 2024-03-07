package com.example.we_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText username, phoneNumber, sex, age, grade, password, passwordConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        phoneNumber = findViewById(R.id.phoneNumber);
        sex = findViewById(R.id.sex);
        age = findViewById(R.id.age);
        grade = findViewById(R.id.grade);
        password = findViewById(R.id.password);
        passwordConfirm = findViewById(R.id.passwordConfirm);

    }

    public void singUp (View view) {

        String userName = username.getText().toString();
        String userPhoneNumber = phoneNumber.getText().toString();
        String userSex = sex.getText().toString();
        String userAge = age.getText().toString();
        String userGrade = grade.getText().toString();
        String userPassword = password.getText().toString();
        String userPasswordConfirm = passwordConfirm.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPhoneNumber)) {
            Toast.makeText(this, "Enter PhoneNumber", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPasswordConfirm)) {
            Toast.makeText(this, "Enter PasswordConfirm", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userPassword.equals(userPasswordConfirm)) {
            Toast.makeText(this, "Your Confirm Password is not matching !", Toast.LENGTH_SHORT).show();
            return;
        }

        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
    }

    public void singIn (View view) {
        startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
    }
}