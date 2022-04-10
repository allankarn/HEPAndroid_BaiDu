package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.TeacherListEntity;
import com.enetedu.hep.utils.ImgUtils;

import java.util.ArrayList;

public class ZjAdapter extends RecyclerView.Adapter {
    private static final String TAG = "ZjAdapter";
    public ArrayList<TeacherListEntity> mList = new ArrayList<>();
    private OnItemListener mlistener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zj_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        ImgUtils.loadImgToUrl(holder.iv_tu.getContext(), mList.get(i).getImgpath(), 0, holder.iv_tu);
        holder.tv_name.setText(mList.get(i).getTeachername());
        holder.tv_zc.setText("职称：" + mList.get(i).getTeacherzhicheng());
        holder.tv_dw.setText("所在单位：" + mList.get(i).getTeacherschool());
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

    public void addData(ArrayList<TeacherListEntity> objects) {

        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_zc;
        private final TextView tv_dw;
        private final ImageView iv_tu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_tu = itemView.findViewById(R.id.iv_tu);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_zc = itemView.findViewById(R.id.tv_zc);
            tv_dw = itemView.findViewById(R.id.tv_dw);
        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
