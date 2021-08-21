package com.haui.phamdai.silentmoon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.models.MeditateCourse;

import java.util.List;

public class MeditateCourseAdapter extends RecyclerView.Adapter<MeditateCourseAdapter.ViewHolder> {

    List<MeditateCourse> meditateCourseList;

    public MeditateCourseAdapter(List<MeditateCourse> meditateCourseList) {
        this.meditateCourseList = meditateCourseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meditate_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MeditateCourse course = meditateCourseList.get(position);

        holder.iv.setImageResource(course.getImage());
        holder.txtName.setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return meditateCourseList.size();
    }

    protected final class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView txtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageViewMeditateCourseItem);
            txtName = itemView.findViewById(R.id.textViewNameMeditateCourseItem);
        }
    }
}
