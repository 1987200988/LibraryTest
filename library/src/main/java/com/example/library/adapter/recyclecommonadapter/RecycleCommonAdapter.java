package com.example.library.adapter.recyclecommonadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class RecycleCommonAdapter<T> extends RecyclerView.Adapter<RecycleCommonViewHolder>
{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;


    public RecycleCommonAdapter(Context context, int layoutId, List<T> datas)
    {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public RecycleCommonViewHolder onCreateViewHolder(final ViewGroup parent, int viewType)
    {
        RecycleCommonViewHolder recycleCommonViewHolder = RecycleCommonViewHolder.get(mContext, parent, mLayoutId);
        return recycleCommonViewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleCommonViewHolder holder, int position)
    {
//        holder.updatePosition(position);
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(RecycleCommonViewHolder holder, T t);

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }
}