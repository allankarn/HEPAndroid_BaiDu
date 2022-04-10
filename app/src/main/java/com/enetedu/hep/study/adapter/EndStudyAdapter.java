package com.enetedu.hep.study.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.Course3ViewListEntity;
import com.enetedu.hep.utils.Date4String;

import java.util.ArrayList;

public class EndStudyAdapter extends RecyclerView.Adapter {
    private static final String TAG = "EndStudyAdapter";
    public ArrayList<Course3ViewListEntity> mList = new ArrayList<>();
    private OnItemListener mlistener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zb_study_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;

        holder.tv_title.setText(mList.get(i).getName());
        if (mList.get(i).getName().equals("我的课单")) {
            holder.tv_time.setText("课程时间：" + new Date4String().date4Str(mList.get(i).getStartTime()) + "~" + new Date4String().date4Str(mList.get(i).getEndTime()));
        } else {
            holder.tv_time.setVisibility(View.GONE);
        }
        int type = Integer.parseInt(mList.get(i).getCourseType());
        if (type == 1) {
            if (mList.get(i).getCourseLists().size() > 0) {
                String str = "";
                for (int j = 0; j < mList.get(i).getCourseLists().size(); j++) {
                    str += mList.get(i).getCourseLists().get(j).getInfo();

                }
                holder.tv_neirong.loadDataWithBaseURL("", str, "text/html", "UTF-8", "");
            }
        } else {
            holder.tv_neirong.loadDataWithBaseURL("", mList.get(i).getName(), "text/html", "UTF-8", "");
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

    public void addData(ArrayList<Course3ViewListEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public void newaddData(ArrayList<Course3ViewListEntity> objects) {
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_title;
        private final WebView tv_neirong;
        private final TextView tv_time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_neirong = itemView.findViewById(R.id.tv_neirong);
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
