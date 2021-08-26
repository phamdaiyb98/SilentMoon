package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.haui.phamdai.silentmoon.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        findViewById(R.id.buttonBack_SignIn).setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInAndSignUpActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonLogin_SignIn).setOnClickListener(v -> {
            Intent intent = new Intent(this, ChooseTopicActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.llSignUp_SignIn).setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}