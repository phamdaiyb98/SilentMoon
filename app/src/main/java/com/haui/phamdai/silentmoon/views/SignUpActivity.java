package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.haui.phamdai.silentmoon.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViewById(R.id.buttonBack_SignUp).setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonGetStarted_SignUp).setOnClickListener(v -> {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        });
    }
}