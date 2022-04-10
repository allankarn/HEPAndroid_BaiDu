package com.enetedu.hep.my.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.NationEntity;

import java.util.ArrayList;

public class NationAdapter extends RecyclerView.Adapter {
    public ArrayList<NationEntity> mList = new ArrayList<>();
    private OnItemListener mlistener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nation_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv_nation.setText(mList.get(i).getName());
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

    public void addData(ArrayList<NationEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_nation;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nation = itemView.findViewById(R.id.tv_nation);

        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
