package com.haui.phamdai.silentmoon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.models.SleepCourse;

import java.util.List;

public class SleepCourseAdapter extends RecyclerView.Adapter<SleepCourseAdapter.ViewHolder> {

    List<SleepCourse> sleepCourseList;
    private final String SLEEP_MUSIC = " • SLEEP MUSIC";

    public SleepCourseAdapter(List<SleepCourse> sleepCourseList) {
        this.sleepCourseList = sleepCourseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sleep_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SleepCourse sleepCourse = sleepCourseList.get(position);

        holder.ivSleepCourse.setImageResource(sleepCourse.getImage());
        holder.txtSleepCourseName.setText(sleepCourse.getName());
        String time = sleepCourse.getTime() + SLEEP_MUSIC;
        holder.txtSleepCourseTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return sleepCourseList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSleepCourse;
        TextView txtSleepCourseName;
        TextView txtSleepCourseTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSleepCourse = itemView.findViewById(R.id.imageViewSleepCourseItem);
            txtSleepCourseName = itemView.findViewById(R.id.textViewSleepCourseNameItem);
            txtSleepCourseTime = itemView.findViewById(R.id.textViewSleepCourseTimeItem);
        }
    }
}
