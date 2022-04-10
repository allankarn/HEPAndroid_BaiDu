package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.Course2ModelEntity;
import com.enetedu.hep.utils.ImgUtils;

import java.util.ArrayList;

public class FreeCourseAdapter extends RecyclerView.Adapter {
    public ArrayList<Course2ModelEntity> mList = new ArrayList<>();
    private OnItemListener mlistener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freelist_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        ImgUtils.loadImgToUrl(holder.iv_tu.getContext(), mList.get(i).getHead_img_url(), 0, holder.iv_tu);
        holder.tv_name.setText(mList.get(i).getSub_teacher_name());
        holder.tv_title.setText(mList.get(i).getName());
        holder.tv_liulan.setText(mList.get(i).getClicks() + "人浏览");
        holder.tv_zaixue.setText(mList.get(i).getEnrollmentCount() + "人在学");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.onlick(view, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size() > 0 ? mList.size() : 0;
    }


    public void addData(ArrayList<Course2ModelEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView iv_tu;
        private final TextView tv_title;
        private final TextView tv_name;
        private final TextView tv_liulan;
        private final TextView tv_zaixue;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_tu = itemView.findViewById(R.id.iv_tu);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_liulan = itemView.findViewById(R.id.tv_liulan);
            tv_zaixue = itemView.findViewById(R.id.tv_zaixue);
        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
