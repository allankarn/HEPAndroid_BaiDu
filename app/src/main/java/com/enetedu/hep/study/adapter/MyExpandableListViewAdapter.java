package com.enetedu.hep.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.StudyMyCourseEntity;

import java.util.List;

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {
    public List<StudyMyCourseEntity> mList;
    private LayoutInflater mInflater;


    public MyExpandableListViewAdapter(Context context, List<StudyMyCourseEntity> mList) {
        this.mInflater = LayoutInflater.from(context);
        this.mList = mList;
    }

    //返回一级列表的个数
    @Override
    public int getGroupCount() {
        return mList.size();
    }

    //返回每个二级列表的个数
    @Override
    public int getChildrenCount(int i) {
        return mList.get(i).getViewenrolldetails().size();
    }

    //返回一级列表的单个item
    @Override
    public Object getGroup(int i) {
        return mList.get(i);
    }

    //返回二级列表中的单个item
    @Override
    public Object getChild(int i, int i1) {
        return mList.get(i).getViewenrolldetails().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    // 定义一个 一级列表的view类
    private class HodlerViewFather {
        TextView tv_group;

    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        HodlerViewFather hodlerViewFather;
        int a = groupPosition + 1;
        if (convertView == null) {
            hodlerViewFather = new HodlerViewFather();
            convertView = mInflater.inflate(R.layout.expandable_group_list, parent, false);
            hodlerViewFather.tv_group = convertView.findViewById(R.id.tv_group);

            convertView.setTag(hodlerViewFather);
        } else {
            hodlerViewFather = (HodlerViewFather) convertView.getTag();
        }
        hodlerViewFather.tv_group.setText(a + "、" + mList.get(groupPosition).getName());
        return convertView;
    }

    // 保存二级列表的视图类
    private class HolderView {
        TextView tv_child_title;
        TextView tv_child_zhuangtai;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        HolderView holderView;
        if (convertView == null) {
            holderView = new HolderView();
            convertView = mInflater.inflate(R.layout.expandable_child_list, parent, false);
            holderView.tv_child_title = convertView.findViewById(R.id.tv_child_title);
            holderView.tv_child_zhuangtai = convertView.findViewById(R.id.tv_child_zhuangtai);
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }
        holderView.tv_child_title.setText(mList.get(groupPosition).getViewenrolldetails().get(childPosition).getName());

        if (mList.get(groupPosition).getViewenrolldetails().get(childPosition).getIs_finished().equals("1")) {
            holderView.tv_child_zhuangtai.setText("已学完");
        } else if (mList.get(groupPosition).getViewenrolldetails().get(childPosition).getIs_finished().equals("0")) {
            holderView.tv_child_zhuangtai.setText("未学完");
        } else {
            holderView.tv_child_zhuangtai.setText("未开始");
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
