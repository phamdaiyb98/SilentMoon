package com.haui.phamdai.silentmoon.widgets.daypicker;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.enums.WeekDay;
import com.haui.phamdai.silentmoon.widgets.timepicker.widget.WheelAmPmPicker;
import com.haui.phamdai.silentmoon.widgets.timepicker.widget.WheelDayPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SingleDayPicker extends LinearLayout {

    @NonNull
    private final ImageButton mIBtnMon;
    @NonNull
    private final ImageButton mIBtnTue;
    @NonNull
    private final ImageButton mIBtnWed;
    @NonNull
    private final ImageButton mIBtnThu;
    @NonNull
    private final ImageButton mIBtnFri;
    @NonNull
    private final ImageButton mIBtnSat;
    @NonNull
    private final ImageButton mIBtnSun;

    private boolean mIsMon;
    private boolean mIsTue;
    private boolean mIsWed;
    private boolean mIsThu;
    private boolean mIsFri;
    private boolean mIsSat;
    private boolean mIsSun;

    private Map<WeekDay, Boolean> mDayMap;

    public SingleDayPicker(Context context) {
        this(context, null);
    }

    public SingleDayPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SingleDayPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.picker_single_day, this);

        mIBtnMon = findViewById(R.id.imageButtonMonDay_DayPicker);
        mIBtnTue = findViewById(R.id.imageButtonTuesday_DayPicker);
        mIBtnWed = findViewById(R.id.imageButtonWednesday_DayPicker);
        mIBtnThu = findViewById(R.id.imageButtonThursday_DayPicker);
        mIBtnFri = findViewById(R.id.imageButtonFriday_DayPicker);
        mIBtnSat = findViewById(R.id.imageButtonSaturday_DayPicker);
        mIBtnSun = findViewById(R.id.imageButtonSunDay_DayPicker);

        initDayMap();
    }

    private void initDayMap() {
        mDayMap = new HashMap<>();
        mDayMap.put(WeekDay.MON, true);
        mIsMon = true;
        mDayMap.put(WeekDay.TUE, true);
        mIsTue = true;
        mDayMap.put(WeekDay.WED, true);
        mIsWed = true;
        mDayMap.put(WeekDay.THU, false);
        mIsThu = false;
        mDayMap.put(WeekDay.FRI, false);
        mIsFri = false;
        mDayMap.put(WeekDay.SAT, true);
        mIsSat = true;
        mDayMap.put(WeekDay.SUN, true);
        mIsSun = true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mIBtnMon.setOnClickListener(v -> {
            if (mIsMon) {
                mIBtnMon.setImageResource(R.drawable.reminders_monday_disable);
            } else {
                mIBtnMon.setImageResource(R.drawable.reminders_monday_enable);
            }
            mIsMon = !mIsMon;
            changeState(WeekDay.MON, mIsMon);
        });

        mIBtnTue.setOnClickListener(v -> {
            if (mIsTue) {
                mIBtnTue.setImageResource(R.drawable.reminders_tuesday_disable);
            } else {
                mIBtnTue.setImageResource(R.drawable.reminders_tuesday_enable);
            }
            mIsTue = !mIsTue;
            changeState(WeekDay.TUE, mIsTue);
        });

        mIBtnWed.setOnClickListener(v -> {
            if (mIsWed) {
                mIBtnWed.setImageResource(R.drawable.reminders_wednesday_disable);
            } else {
                mIBtnWed.setImageResource(R.drawable.reminders_wednesday_enable);
            }
            mIsWed = !mIsWed;
            changeState(WeekDay.WED, mIsWed);
        });

        mIBtnThu.setOnClickListener(v -> {
            if (mIsThu) {
                mIBtnThu.setImageResource(R.drawable.reminders_thursday_disable);
            } else {
                mIBtnThu.setImageResource(R.drawable.reminders_thursday_enable);
            }
            mIsThu = !mIsThu;
            changeState(WeekDay.THU, mIsThu);
        });

        mIBtnFri.setOnClickListener(v -> {
            if (mIsFri) {
                mIBtnFri.setImageResource(R.drawable.reminders_friday_disable);
            } else {
                mIBtnFri.setImageResource(R.drawable.reminders_friday_enable);
            }
            mIsFri = !mIsFri;
            changeState(WeekDay.FRI, mIsFri);
        });

        mIBtnSat.setOnClickListener(v -> {
            if (mIsSat) {
                mIBtnSat.setImageResource(R.drawable.reminders_saturday_disable);
            } else {
                mIBtnSat.setImageResource(R.drawable.reminders_saturday_enable);
            }
            mIsSat = !mIsSat;
            changeState(WeekDay.SAT, mIsSat);
        });

        mIBtnSun.setOnClickListener(v -> {
            if (mIsSun) {
                mIBtnSun.setImageResource(R.drawable.reminders_sunday_disable);
            } else {
                mIBtnSun.setImageResource(R.drawable.reminders_sunday_enable);
            }
            mIsSun = !mIsSun;
            changeState(WeekDay.SUN, mIsSun);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void changeState(WeekDay selectedWeekDay, boolean state) {
        for (WeekDay weekDay : mDayMap.keySet()) {
            if (weekDay.equals(selectedWeekDay)) {
                mDayMap.replace(weekDay, state);
            }
        }
    }

    public Set<WeekDay> getDays() {
        Set<WeekDay> daySet = new HashSet<>();
        for (WeekDay weekDay : mDayMap.keySet()) {
//            mDayMap được fix cứng nên sẽ không có Exception
            if (mDayMap.get(weekDay)) {
                daySet.add(weekDay);
            }
        }
        return daySet;
    }
}
