package com.example.library.mvp;


import com.example.library.mvp.ibase.IBaseModel;
import com.example.library.mvp.ibase.IBasePresenter;
import com.example.library.mvp.ibase.IBaseView;

/**
 * 类描述：Presenter模块的基类，持有对应的View模块对象
 * 创建人：liwei
 * 创建时间：2016/7/6 10:21
 */
public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView>
        implements IBasePresenter {

    private V mView;

    private M mModel;

    public BasePresenter(V v) {
        mView = v;
        mModel = createModel();
    }

    protected abstract M createModel();

    @Override
    public void onDestroy() {
        if(mModel!=null)
            mModel.onDestroy();
        mModel=null;
    }

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }
}
