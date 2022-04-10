package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.CaddressListEntity;

import java.util.ArrayList;

public class PeiXunAdapter extends RecyclerView.Adapter {

    private OnItemListener mlistener;
    public ArrayList<CaddressListEntity> mList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rlv_peixun, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv_name.setText(mList.get(i).getAddress());


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

    public void addData(ArrayList<CaddressListEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);

        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
