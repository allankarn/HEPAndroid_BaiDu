package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.SubcList;

import java.util.ArrayList;

public class FenAdapter extends RecyclerView.Adapter {
    public ArrayList<SubcList> mList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fen_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv_fen.setText(mList.get(i).getCenterType() + "    " + mList.get(i).getName());

        holder.rlv_fen.setLayoutManager(new LinearLayoutManager(holder.rlv_fen.getContext()));
        /*JzXueXiAdapter jzXueXiAdapter = new JzXueXiAdapter();
        jzXueXiAdapter.addDataFen(mList.get(i).getTjLists());
        holder.rlv_fen.setAdapter(jzXueXiAdapter);*/
    }

    @Override
    public int getItemCount() {
        return mList.size() > 0 ? mList.size() : 0;
    }

    public void addData(ArrayList<SubcList> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_fen;
        private final RecyclerView rlv_fen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_fen = itemView.findViewById(R.id.tv_fen);
            rlv_fen = itemView.findViewById(R.id.rlv_fen);


        }
    }
}
