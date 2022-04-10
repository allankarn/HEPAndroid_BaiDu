package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.TodayCourseListEntity;

import java.util.ArrayList;

public class FocusAdapter extends RecyclerView.Adapter {
    private OnItemListener mlistener;
    public ArrayList<TodayCourseListEntity> mList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.focus_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.biaoqian.setText("[" + mList.get(i).getCoursetype() + "]");
        holder.course.setText(mList.get(i).getName());
        holder.time.setText(mList.get(i).getTime());
      //  holder.zhuangtai.setText(mList.get(i).getCtype());
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

    public void addData(ArrayList<TodayCourseListEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView biaoqian;
        private final TextView course;
        private final TextView time;
     //   private final TextView zhuangtai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            biaoqian = itemView.findViewById(R.id.biaoqian);
            course = itemView.findViewById(R.id.course);
            time = itemView.findViewById(R.id.time);
            //zhuangtai = itemView.findViewById(R.id.zhuangtai);
        }
    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
