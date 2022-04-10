package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.CourseListEntity;
import com.enetedu.hep.utils.ImgUtils;

import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter {

    public ArrayList<CourseListEntity> mList = new ArrayList<>();
    private OnItemListener mlistener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.courselist_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        ImgUtils.loadImgToUrl(holder.iv.getContext(), mList.get(i).getImg_url(), 0, holder.iv);
        holder.tv_name.setText(mList.get(i).getName());
        holder.tv_shouke.setText("授课方式：" + mList.get(i).getShowType());
        holder.tv_xueshi.setText("学时单位：" + mList.get(i).getVideoTime());
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

    public void addData(ArrayList<CourseListEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public void newaddData(ArrayList<CourseListEntity> objects) {
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_shouke;
        private final ImageView iv;
        private final TextView tv_xueshi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_shouke = itemView.findViewById(R.id.tv_shouke);
            tv_xueshi = itemView.findViewById(R.id.tv_xueshi);
        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
