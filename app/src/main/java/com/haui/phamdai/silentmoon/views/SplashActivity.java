package com.haui.phamdai.silentmoon.views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import com.haui.phamdai.silentmoon.R;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnGetStarted;
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 18) {
            setContentView(R.layout.activity_welcome);
            btnGetStarted = findViewById(R.id.buttonGetStarted_Welcome);
        } else {
            setContentView(R.layout.activity_welcome_sleep);
            btnGetStarted = findViewById(R.id.buttonGetStarted_WelcomeSleep);
        }

        btnGetStarted.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInAndSignUpActivity.class);
            startActivity(intent);
//            startWifiQRCodeScanner(this);
        });
    }

//    test easy qr scanner
//    @RequiresApi(api = Build.VERSION_CODES.Q)
//    private void startWifiQRCodeScanner(Context context)
//    {
//        final String INTENT_ACTION_WIFI_QR_SCANNER = "android.settings.WIFI_DPP_ENROLLEE_QR_CODE_SCANNER";
//        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//
//        if(wifiManager.isEasyConnectSupported())
//        {
//            final Intent intent = new Intent(INTENT_ACTION_WIFI_QR_SCANNER);
//            startActivityForResult(intent, 5000);
//        }
//    }
}