package com.haui.phamdai.silentmoon.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.views.PlayOptionActivity;
import com.haui.phamdai.silentmoon.adapters.MeditateTopicAdapter;
import com.haui.phamdai.silentmoon.adapters.SleepCourseAdapter;
import com.haui.phamdai.silentmoon.models.MeditateTopic;
import com.haui.phamdai.silentmoon.models.SleepCourse;
import com.haui.phamdai.silentmoon.enums.SleepScreen;
import com.haui.phamdai.silentmoon.utils.ColorUtil;
import com.haui.phamdai.silentmoon.utils.ItemClickSupport;
import com.haui.phamdai.silentmoon.utils.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;

public class SleepFragment extends Fragment {

    RecyclerView rvSleepCourse;
    RecyclerView rvMeditateTopic;
    Button ibtnStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sleep, container, false);

        rvSleepCourse = view.findViewById(R.id.recyclerViewSleepCourse_Sleep);
        rvMeditateTopic = view.findViewById(R.id.recyclerViewMediateTopic_Sleep);
        ibtnStart = view.findViewById(R.id.buttonStart_Sleep);

        ibtnStart.setOnClickListener(v -> {
            //thay fragment này bằng SleepMusicFragment
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.sleepFragmentContainer, SleepMusicFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        });

        // Meditate Topic
        rvMeditateTopic = view.findViewById(R.id.recyclerViewMediateTopic_Sleep);
        Context contextMeditateTopic = rvMeditateTopic.getContext();

        ColorStateList activeBtn = ColorUtil.getColor(view.getContext(), R.color.sleep_topic_button_active);
        ColorStateList inactiveBtn = ColorUtil.getColor(view.getContext(), R.color.sleep_topic_button_inactive);
        ColorStateList activeTxt = ColorUtil.getColor(view.getContext(), R.color.sleep_topic_text_active);
        ColorStateList inactiveTxt = ColorUtil.getColor(view.getContext(), R.color.sleep_topic_text_inactive);

        MeditateTopicAdapter adapter = new MeditateTopicAdapter(getData(), activeBtn, inactiveBtn, activeTxt, inactiveTxt);
        rvMeditateTopic.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(contextMeditateTopic);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvMeditateTopic.setLayoutManager(manager);

        LayoutMarginDecoration decoration = new LayoutMarginDecoration(20);
        rvMeditateTopic.addItemDecoration(decoration);

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
            intent.putExtra("data", SleepScreen.SLEEP_FRAGMENT);
            startActivity(intent);
        });

        return view;
    }

    private List<MeditateTopic> getData() {
        List<MeditateTopic> meditateTopicList = new ArrayList<>();
        meditateTopicList.add(new MeditateTopic(0, R.drawable.meditate_v2_all_category, "All"));
        meditateTopicList.add(new MeditateTopic(1, R.drawable.meditate_v2_my_category, "My"));
        meditateTopicList.add(new MeditateTopic(2, R.drawable.meditate_v2_anxious_category, "Anxious"));
        meditateTopicList.add(new MeditateTopic(3, R.drawable.meditate_v2_sleep_category, "Sleep"));
        meditateTopicList.add(new MeditateTopic(4, R.drawable.meditate_v2_kids_category, "Kids"));
        meditateTopicList.add(new MeditateTopic(5, R.drawable.meditate_v2_all_category, "Test 1"));
        meditateTopicList.add(new MeditateTopic(6, R.drawable.meditate_v2_all_category, "Test 2"));
        meditateTopicList.add(new MeditateTopic(7, R.drawable.meditate_v2_all_category, "Test 3"));

        return meditateTopicList;
    }

    private List<SleepCourse> getChildData() {
        List<SleepCourse> sleepCourses = new ArrayList<>();
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Night Island", "45 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course2, "Sweet Sleep", "30 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course3, "Sleep Course 1", "24 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course4, "Sleep Course 2", "56 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 3", "11 MIN"));
        sleepCourses.add(new SleepCourse(R.drawable.sleep_course1, "Sleep Course 4", "7 MIN"));

        return sleepCourses;
    }
}