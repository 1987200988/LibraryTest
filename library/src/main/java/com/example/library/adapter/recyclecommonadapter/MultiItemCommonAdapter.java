package com.example.library.adapter.recyclecommonadapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

public abstract class MultiItemCommonAdapter<T> extends RecycleCommonAdapter<T>
{
    protected MultiItemTypeSupport<T> mMultiItemTypeSupport;
    public interface MultiItemTypeSupport<T>
    {
        int getLayoutId(int itemType);

        int getItemViewType(int position, T t);
    }
    public MultiItemCommonAdapter(Context context, List<T> datas,
                                  MultiItemTypeSupport<T> multiItemTypeSupport)
    {
        super(context,-1, datas );
        mMultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getItemViewType(int position)
    {
        return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
    }

    @Override
    public RecycleCommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        RecycleCommonViewHolder holder = RecycleCommonViewHolder.get(mContext, parent, layoutId);
        return holder;
    }

}