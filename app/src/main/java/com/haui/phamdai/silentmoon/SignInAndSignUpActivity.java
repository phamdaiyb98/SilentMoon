package com.haui.phamdai.silentmoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.haui.phamdai.silentmoon.views.RemindersActivity;
import com.haui.phamdai.silentmoon.views.SignInActivity;
import com.haui.phamdai.silentmoon.views.SignUpActivity;
import com.haui.phamdai.silentmoon.views.WelcomeSleepActivity;

import java.util.Objects;

public class SignInAndSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_and_sign_up);

//        findViewById(R.id.buttonSignUp_SignUpAndSignIn).setOnClickListener(v -> {
//            Intent intent = new Intent(this, SignUpActivity.class);
//            startActivity(intent);
//        });

//        for test
        findViewById(R.id.buttonSignUp_SignUpAndSignIn).setOnClickListener(v -> {
            Intent intent = new Intent(this, WelcomeSleepActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.llLogin_SignUpAndSignIn).setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });

        TextInputEditText textInputEditText = new TextInputEditText(this);
        Objects.requireNonNull(textInputEditText.getText()).toString();
    }
}