package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.adapters.TopicAdapter;
import com.haui.phamdai.silentmoon.models.Topic;
import com.haui.phamdai.silentmoon.utils.ItemClickSupport;
import com.haui.phamdai.silentmoon.utils.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;

public class ChooseTopicActivity extends AppCompatActivity {

    private List<Topic> topicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_topic);

        getTopicList();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTopic_ChooseTopic);
        TextView txtFocus = findViewById(R.id.textViewFocusTopic_ChooseTopic);

        txtFocus.bringToFront();
        recyclerView.bringToFront();

        // Setting the layout as Staggered Grid for vertical orientation
        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(new TopicAdapter(topicList));

        LayoutMarginDecoration decoration = new LayoutMarginDecoration(2, 24);
        recyclerView.addItemDecoration(decoration);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener((parent, view12, position, id) -> {
            Toast.makeText(this, "Bạn chọn " + topicList.get(position).getTopic(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, RemindersActivity.class);
            startActivity(intent);
        });
    }

    private void getTopicList() {
        topicList = new ArrayList<>();
        topicList.add(new Topic(R.drawable.large_topic, "Reduce Stress 1"));
        topicList.add(new Topic(R.drawable.small_topic, "Personal Growth 2"));
        topicList.add(new Topic(R.drawable.large_topic, "Reduce Stress 3"));
        topicList.add(new Topic(R.drawable.small_topic, "Reduce Stress 4"));
        topicList.add(new Topic(R.drawable.large_topic, "Personal Growth 5"));
        topicList.add(new Topic(R.drawable.small_topic, "Reduce Stress 6"));
        topicList.add(new Topic(R.drawable.large_topic, "Personal Growth 7"));
    }
}