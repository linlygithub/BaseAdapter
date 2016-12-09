package com.linly.baseadapterlibrary.baselistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linly.baseadapterlibrary.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static com.linly.baseadapterlibrary.baselistview.ViewHolder.getViewHolder;

/**
 * Created by linly on 2016-12-09.
 */

public class CommAdapter extends BaseAdapter{

    Context mContext;
    int mItemResId;
    int mTextId;
    ArrayList<String> mList;
    public CommAdapter(Context context, int itemResId, int textId, ArrayList list) {
        mContext = context;
        mList = list;
        mItemResId = itemResId;
        mTextId = textId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getViewHolder(mContext,convertView,mItemResId,parent);
        TextView t = holder.getView(mTextId);
        t.setText((String) getItem(position));
        return holder.getConvertView();
    }
}
