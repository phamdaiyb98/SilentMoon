package com.haui.phamdai.silentmoon.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.views.Music2Activity;
import com.haui.phamdai.silentmoon.adapters.MeditateCourseAdapter;
import com.haui.phamdai.silentmoon.adapters.MeditateTopicAdapter;
import com.haui.phamdai.silentmoon.models.MeditateCourse;
import com.haui.phamdai.silentmoon.models.MeditateTopic;
import com.haui.phamdai.silentmoon.utils.ColorUtil;
import com.haui.phamdai.silentmoon.utils.ItemClickSupport;
import com.haui.phamdai.silentmoon.utils.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;

public class MeditateFragment extends Fragment {

    RecyclerView rvMeditateTopic;
    RecyclerView rvMeditateCourse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meditate, container, false);

        // Meditate Topic
        rvMeditateTopic = view.findViewById(R.id.recyclerViewMediateTopic_Meditate2);
        Context contextMeditateTopic = rvMeditateTopic.getContext();

        ColorStateList activeBtn = ColorUtil.getColor(view.getContext(), R.color.topic_button_active);
        ColorStateList inactiveBtn = ColorUtil.getColor(view.getContext(), R.color.topic_button_inactive);
        ColorStateList activeTxt = ColorUtil.getColor(view.getContext(), R.color.topic_text_active);
        ColorStateList inactiveTxt = ColorUtil.getColor(view.getContext(), R.color.topic_text_inactive);

        MeditateTopicAdapter adapter = new MeditateTopicAdapter(getData(), activeBtn, inactiveBtn, activeTxt, inactiveTxt);
        rvMeditateTopic.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(contextMeditateTopic);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvMeditateTopic.setLayoutManager(manager);

        LayoutMarginDecoration decoration = new LayoutMarginDecoration(20);
        rvMeditateTopic.addItemDecoration(decoration);

        //Meditate Course
        rvMeditateCourse = view.findViewById(R.id.recyclerViewMediateCourse_Meditate2);
        Context contextMeditateCourse = rvMeditateCourse.getContext();

        MeditateCourseAdapter adapter1 = new MeditateCourseAdapter(getChildData());
        rvMeditateCourse.setAdapter(adapter1);

        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        rvMeditateCourse.setLayoutManager(layoutManager);

        LayoutMarginDecoration marginDecoration = new LayoutMarginDecoration(2, 24);
        rvMeditateCourse.addItemDecoration(marginDecoration);

        ItemClickSupport.addTo(rvMeditateCourse).setOnItemClickListener((parent, view1, position, id) -> {
            Toast.makeText(contextMeditateCourse, getChildData().get(position).getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), Music2Activity.class);
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

    private List<MeditateCourse> getChildData() {
        List<MeditateCourse> meditateCourses = new ArrayList<>();
        meditateCourses.add(new MeditateCourse(0, R.drawable.meditate_v2_calm1, "7 Days of Calm"));
        meditateCourses.add(new MeditateCourse(1, R.drawable.meditate_v2_calm2, "Anxiet Release"));
        meditateCourses.add(new MeditateCourse(2, R.drawable.meditate_v2_calm4, "Course 2"));
        meditateCourses.add(new MeditateCourse(3, R.drawable.meditate_v2_calm3, "Course 1"));
        meditateCourses.add(new MeditateCourse(4, R.drawable.meditate_v2_calm1, "Course 3"));
        meditateCourses.add(new MeditateCourse(5, R.drawable.meditate_v2_calm1, "Course 4"));
        meditateCourses.add(new MeditateCourse(6, R.drawable.meditate_v2_calm1, "Course 5"));

        return meditateCourses;
    }
}