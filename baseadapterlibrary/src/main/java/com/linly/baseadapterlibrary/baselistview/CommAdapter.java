package com.linly.baseadapterlibrary.baselistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by linly on 2016-12-09.
 */

public abstract class CommAdapter<T> extends BaseAdapter{

    Context mContext;
    int mItemResId;
    List<T> mList;
    public CommAdapter(Context context, int itemResId, int textId, List<T> list) {
        mContext = context;
        mList = list;
        mItemResId = itemResId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getViewHolder(mContext,convertView,mItemResId,parent);
        convert(holder,getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T data);
}
