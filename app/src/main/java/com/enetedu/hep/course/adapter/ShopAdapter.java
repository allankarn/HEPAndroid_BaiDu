package com.enetedu.hep.course.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.ShoppingCartListEntity;
import com.enetedu.hep.utils.ImgUtils;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter {

    public ArrayList<ShoppingCartListEntity> mList = new ArrayList<>();
    private onItemCheckListener ono;
    private OnItemListener mlistener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shop_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.cb.setChecked(mList.get(i).isCheck());
        ImgUtils.loadImgToUrl(holder.iv_tu.getContext(), mList.get(i).getImgurl(), 0, holder.iv_tu);
        holder.tv_name.setText(mList.get(i).getCourseName());
        holder.tv_xueshi.setText(mList.get(i).getCourseCerdit());
        holder.tv_fangshi.setText("在线");

        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ono != null) {
                    ono.onItemCheck(i);
                }
            }
        });

        holder.iv_shanchu.setOnClickListener(new View.OnClickListener() {
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

    public void addData(ArrayList<ShoppingCartListEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    //获取选中的数据
    public ArrayList<ShoppingCartListEntity> getCheckData() {
        ArrayList<ShoppingCartListEntity> objects = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).isCheck()){
                objects.add(mList.get(i));
            }
        }
        return objects;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final CheckBox cb;
        private final ImageView iv_tu;
        private final TextView tv_name;
        private final TextView tv_xueshi;
        private final TextView tv_fangshi;
        private final ImageView iv_shanchu;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cb = itemView.findViewById(R.id.check);
            iv_tu = itemView.findViewById(R.id.iv_tu);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_xueshi = itemView.findViewById(R.id.tv_xueshi);
            tv_fangshi = itemView.findViewById(R.id.tv_fangshi);
            iv_shanchu = itemView.findViewById(R.id.iv_shanchu);
        }
    }

    public interface onItemCheckListener {
        void onItemCheck(int position);
    }

    public void onItemCheck(onItemCheckListener listener) {
        ono = listener;

    }

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
