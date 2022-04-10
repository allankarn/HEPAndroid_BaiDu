package com.enetedu.hep.news.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.InfoListEntity;
import com.enetedu.hep.utils.Date4String;

import java.util.ArrayList;

public class NewsVpAdapter extends RecyclerView.Adapter {
    public ArrayList<InfoListEntity> mList = new ArrayList<>();
    private OnItemListener mlistener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_vp_adapter, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        int num = i + 1;
        holder.tv_shu.setText("[" + num + "]");
        holder.tv_tittle.setText(mList.get(i).getTITLE());
        holder.tv_time.setText(new Date4String().date4Str(mList.get(i).getINPUT_TIME(), "yyyy-MM-dd"));
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

    public void addData(ArrayList<InfoListEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public void newaddData(ArrayList<InfoListEntity> objects) {
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_tittle;
        private final TextView tv_time;
        private final TextView tv_shu;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_shu = itemView.findViewById(R.id.tv_shu);
            tv_tittle = itemView.findViewById(R.id.tv_tittle);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
