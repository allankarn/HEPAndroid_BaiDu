package com.enetedu.hep.my.adapter;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.ArchivesEntity;
import com.enetedu.hep.utils.Date4String;

import java.util.ArrayList;

public class ArchivesAdapter extends RecyclerView.Adapter {
    public ArrayList<ArchivesEntity> mList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.certificate_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv_name.setText(mList.get(i).getREMARK());

        if (mList.get(i).getIN_OUT_FLAG().equals("1")) {

            holder.tv_xuefen.setText("+" + mList.get(i).getCREDIT());

        } else {

            holder.tv_xuefen.setText("-" + mList.get(i).getCREDIT());
            holder.tv_xuefen.setTextColor(Color.parseColor("#5BABE4"));

        }

        holder.tv_time.setText(new Date4String().date4Str(mList.get(i).getCREDIT_TIME(), "yyyy-MM-dd"));
    }

    @Override
    public int getItemCount() {
        return mList.size() > 0 ? mList.size() : 0;
    }

    public void addData(ArrayList<ArchivesEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public void newaddData(ArrayList<ArchivesEntity> objects) {
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_time;
        private final TextView tv_xuefen;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_xuefen = itemView.findViewById(R.id.tv_xuefen);
        }
    }
}
