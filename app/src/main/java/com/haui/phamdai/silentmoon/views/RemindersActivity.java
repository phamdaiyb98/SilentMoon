package com.haui.phamdai.silentmoon.views;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.enums.WeekDay;
import com.haui.phamdai.silentmoon.widgets.daypicker.SingleDayPicker;
import com.haui.phamdai.silentmoon.widgets.timepicker.SingleDateAndTimePicker;

import java.util.Date;

public class RemindersActivity extends AppCompatActivity {

    private SingleDateAndTimePicker mTimePicker;
    private SingleDayPicker mDayPicker;
    private Button mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        mTimePicker = findViewById(R.id.singleTimePicker_Reminders);
        mBtnSave = findViewById(R.id.buttonSave_Reminders);
        mDayPicker = findViewById(R.id.singleDayPicker_Reminders);

        mTimePicker.setIsAmPm(true);
//        mPicker.addOnDateChangedListener((displayed, date) -> display(date));

        mBtnSave.setOnClickListener(v -> {
//            Toast.makeText(this, DateFormat.format("h:mm a",
//                    mTimePicker.getDate()).toString(), Toast.LENGTH_SHORT).show();
            for (WeekDay weekDay : mDayPicker.getDays()) {
                Log.d("AAA", weekDay.name());
            }
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void display(Date date) {
        Toast.makeText(this, DateFormat.format("h:mm a", date).toString(), Toast.LENGTH_SHORT).show();
    }
}