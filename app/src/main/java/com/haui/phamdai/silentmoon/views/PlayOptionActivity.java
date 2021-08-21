package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.adapters.SleepCourseAdapter;
import com.haui.phamdai.silentmoon.models.SleepCourse;
import com.haui.phamdai.silentmoon.enums.SleepScreen;
import com.haui.phamdai.silentmoon.utils.ItemClickSupport;
import com.haui.phamdai.silentmoon.utils.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;

public class PlayOptionActivity extends AppCompatActivity {

    RecyclerView rvSleepCourse;
    Button ibtnPlay;
    ImageButton ibtnBack;
    SleepScreen lastSleepScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_option);

        rvSleepCourse = findViewById(R.id.recyclerViewSleepCourse_PlayOption);
        ibtnPlay = findViewById(R.id.buttonPlay_PlayOption);
        ibtnBack = findViewById(R.id.buttonBack_PlayOption);

        lastSleepScreen = (SleepScreen) getIntent().getSerializableExtra("data");

        ibtnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(this, MusicActivity.class);
            intent.putExtra("data", lastSleepScreen);
            startActivity(intent);
        });

        ibtnBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("screen", lastSleepScreen);
            intent.putExtra("data", bundle);
            startActivity(intent);
        });

        // sleep course
        SleepCourseAdapter sleepCourseAdapter = new SleepCourseAdapter(getData());
        rvSleepCourse.setAdapter(sleepCourseAdapter);

        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        rvSleepCourse.setLayoutManager(layoutManager);

        LayoutMarginDecoration marginDecoration = new LayoutMarginDecoration(2, 35);
        rvSleepCourse.addItemDecoration(marginDecoration);

        ItemClickSupport.addTo(rvSleepCourse).setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(view.getContext(), "Bạn chọn " + getData().get(position).getName(), Toast.LENGTH_LONG).show();
        });

    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        outState.putSerializable("sendData", lastSleepScreen);
//    }

    private List<SleepCourse> getData() {
        List<SleepCourse> sleepCourses = new ArrayList<>();
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course2, "Sweet Sleep", "30 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course3, "Sleep Course 1", "24 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course4, "Sleep Course 2", "56 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 3", "11 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 4", "7 MIN"));

        return sleepCourses;
    }
}