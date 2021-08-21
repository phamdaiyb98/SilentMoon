package com.haui.phamdai.silentmoon.fragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.views.PlayOptionActivity;
import com.haui.phamdai.silentmoon.adapters.SleepCourseAdapter;
import com.haui.phamdai.silentmoon.models.SleepCourse;
import com.haui.phamdai.silentmoon.enums.SleepScreen;
import com.haui.phamdai.silentmoon.utils.ItemClickSupport;
import com.haui.phamdai.silentmoon.utils.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;

public class SleepMusicFragment extends Fragment {

    RecyclerView rvSleepCourse;
    ImageButton ibtnBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sleep_music, container, false);

        rvSleepCourse = view.findViewById(R.id.recyclerViewSleepCourse_SleepMusic);
        ibtnBack = view.findViewById(R.id.buttonBack_SleepMusic);

        ibtnBack.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.sleepFragmentContainer, SleepFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        });

        // sleep course
        SleepCourseAdapter sleepCourseAdapter = new SleepCourseAdapter(getChildData());
        rvSleepCourse.setAdapter(sleepCourseAdapter);

        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        rvSleepCourse.setLayoutManager(layoutManager);

        LayoutMarginDecoration marginDecoration = new LayoutMarginDecoration(2, 35);
        rvSleepCourse.addItemDecoration(marginDecoration);

        ItemClickSupport.addTo(rvSleepCourse).setOnItemClickListener((parent, view1, position, id) -> {
            Toast.makeText(view.getContext(), "Bạn chọn " + getChildData().get(position).getName(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(view.getContext(), PlayOptionActivity.class);
            intent.putExtra("data", SleepScreen.SLEEP_MUSIC_FRAGMENT);
            startActivity(intent);
        });

        return view;
    }

    private List<SleepCourse> getChildData() {
        List<SleepCourse> sleepCourses = new ArrayList<>();
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Night Island", "45 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course2, "Sweet Sleep", "30 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course3, "Sleep Course 1", "24 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course4, "Sleep Course 2", "56 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 3", "11 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 4", "7 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 5", "56 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 6", "34 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 7", "25 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 8", "46 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 9", "15 MIN"));

        return sleepCourses;
    }


}