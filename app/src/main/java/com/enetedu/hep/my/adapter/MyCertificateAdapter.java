package com.enetedu.hep.my.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.MyCertificateEntity;
import com.enetedu.hep.utils.Date4String;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyCertificateAdapter extends RecyclerView.Adapter {
    private OnItemListener mlistener;
    public ArrayList<MyCertificateEntity> mList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.certificate_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv_name.setText(mList.get(i).getCOURSE_NAME());

        //  BigDecimal bigDecimal = new BigDecimal(mList.get(i).getCREDIT());
        DecimalFormat df = new DecimalFormat("#####0.00");
        String str = df.format(mList.get(i).getCREDIT());
        holder.tv_xuefen.setText(str);

        holder.tv_time.setText(new Date4String().date4Str(mList.get(i).getCredit_start_time(), "yyyy-MM-dd"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.onlick(view, i);
            }
        });
    }

    public static String totalMoney(double money) {
        BigDecimal bigDec = new BigDecimal(money);
        double total = bigDec.setScale(2, java.math.BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(total);
    }

    @Override
    public int getItemCount() {
        return mList.size() > 0 ? mList.size() : 0;
    }

    public void addData(ArrayList<MyCertificateEntity> objects) {
        mList.clear();
        mList.addAll(objects);
        notifyDataSetChanged();
    }

    public void newaddData(ArrayList<MyCertificateEntity> objects) {
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

    public interface OnItemListener {
        void onlick(View v, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mlistener = listener;
    }
}
