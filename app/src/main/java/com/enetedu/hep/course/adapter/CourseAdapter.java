package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.HaoKeEntity;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter {
    private OnItemListener mlistener;
    public ArrayList<HaoKeEntity> mList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.couse_adapter, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.zhibo.setText("[在线]");
        holder.couse.setText(mList.get(i).getNAME());
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

    public void addData(ArrayList<HaoKeEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView zhibo;
        private final TextView couse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zhibo = itemView.findViewById(R.id.tv_zhibo);
            couse = itemView.findViewById(R.id.tv_couse);
        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
