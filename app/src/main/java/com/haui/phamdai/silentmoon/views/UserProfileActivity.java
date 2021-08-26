package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import com.haui.phamdai.silentmoon.R;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        EditText edtName = findViewById(R.id.editTextYourName_UserProfile);
        EditText edtEmail = findViewById(R.id.editTextLoginEmail_UserProfile);
    }
}