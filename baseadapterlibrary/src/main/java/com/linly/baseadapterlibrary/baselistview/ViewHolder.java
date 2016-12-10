package com.linly.baseadapterlibrary.baselistview;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.linly.baseadapterlibrary.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.media.CamcorderProfile.get;

/**
 * Created by linly on 2016-12-09.
 */

public class ViewHolder {
    private static int count;
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;//需要加载布局
    private int mItemPosition;

    /**
     * ViewHolder构造函数
     * 非复用布局使用setTag存储该viewholder
     *
     * @param context  上下文
     * @param resId    item布局id
     * @param rootView 父view
     */
    private ViewHolder(Context context, int resId, ViewGroup rootView, int itemPosition) {
        mViews = new SparseArray<View>();
        mContext = context;
        mConvertView = LayoutInflater.from(mContext).inflate(resId, rootView, false);
        mItemPosition = itemPosition;
        mConvertView.setTag(this);
    }

    /**
     * 获取Viewholder
     *
     * @param context     上下文
     * @param convertView 加载的布局
     * @param resId       item布局资源id
     * @param rootView    父View
     * @return
     */
    public static ViewHolder getViewHolder(Context context, View convertView, int resId, ViewGroup rootView, int position) {
        ViewHolder holder = null;
        if (convertView == null) {//如果布局中没有viewholder
            Log.d("getViewHolder", "创建对象");
            holder = new  ViewHolder(context, resId, rootView, position);
        }else {
            holder = (ViewHolder) convertView.getTag();
            holder.mItemPosition = position;
        }
        return holder;

    }

    public <T extends View> T getView(int resId) {
        View v = mViews.get(resId);
        if (v == null) {
            v = mConvertView.findViewById(resId);
            mViews.put(resId, v);
        }
        return (T) v;
    }

    /**
     * 返回加载的布局
     *
     * @return
     */
    public View getConvertView() {
        return mConvertView;
    }

    public int getItemPosition() {
        return this.mItemPosition;
    }
 }
