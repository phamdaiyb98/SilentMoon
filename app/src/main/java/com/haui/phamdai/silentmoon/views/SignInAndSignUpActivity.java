package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.haui.phamdai.silentmoon.R;

import java.util.Objects;

public class SignInAndSignUpActivity extends AppCompatActivity {

    Button btnSignUp;
    LinearLayout llSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_and_sign_up);

        btnSignUp = findViewById(R.id.buttonSignUp_SignUpAndSignIn);
        llSignIn = findViewById(R.id.llLogin_SignUpAndSignIn);

        llSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInAndSignUpActivity.class);
            startActivity(intent);
        });

        btnSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInAndSignUpActivity.class);
            startActivity(intent);
        });
    }


    @Override
    public void onBackPressed() {
        //close app không quay lại splash nữa
        finishAffinity();
    }
}