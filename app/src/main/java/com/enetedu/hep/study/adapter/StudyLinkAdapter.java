package com.enetedu.hep.study.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.StudyLinkEntity;

import java.util.ArrayList;

public class StudyLinkAdapter extends RecyclerView.Adapter {
    public ArrayList<StudyLinkEntity> mList = new ArrayList<>();
    private OnItemListener mlistener;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.study_link_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        ViewHolder holder = (ViewHolder) viewHolder;

        int a = i + 1;
        if (mList.get(i).getState() == 1) {
            holder.tv_name.setText(a + "、" + mList.get(i).getName() + "(已完成)");
        } else {
            holder.tv_name.setText(a + "、" + mList.get(i).getName());
        }

        if (i == 0) {
            holder.tv_name.setBackgroundResource(R.drawable.studylinklist);
        } else if (i == 1) {
            holder.tv_name.setBackgroundResource(R.drawable.studylinklist2);
        } else if (i == 2) {
            holder.tv_name.setBackgroundResource(R.drawable.studylinklist3);
        } else if (i == 3) {
            holder.tv_name.setBackgroundResource(R.drawable.studylinklist4);
        } else if (i == 4) {
            holder.tv_name.setBackgroundResource(R.drawable.studylinklist5);
        }

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

    public void addData(ArrayList<StudyLinkEntity> objects) {

        mList.clear();

        ArrayList<StudyLinkEntity> studyLinkEntities = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getDisplay() == 1) {
                studyLinkEntities.add(objects.get(i));
            }
        }
        mList.addAll(studyLinkEntities);
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
