package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.TjList;

import java.util.ArrayList;

public class JzXueXiAdapter extends RecyclerView.Adapter {
    public ArrayList<TjList> mList = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zjxuexi_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv_courseday.setText(mList.get(i).getCourseday());
        holder.tv_coursexueyuan.setText(mList.get(i).getCoursexueyuan());

    }

    @Override
    public int getItemCount() {
        return mList.size() > 0 ? mList.size() : 0;
    }

    public void addData(ArrayList<TjList> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public void addDataFen(ArrayList<TjList> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_courseday;
        private final TextView tv_coursexueyuan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_courseday = itemView.findViewById(R.id.tv_courseday);
            tv_coursexueyuan = itemView.findViewById(R.id.tv_coursexueyuan);
        }
    }
}
