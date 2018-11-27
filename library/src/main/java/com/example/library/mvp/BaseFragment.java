//package com.example.library.mvp;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//
//import com.example.library.baseactivity.BaseActivity;
//import com.example.library.mvp.ibase.IBaseView;
//import com.example.library.mvp.ibase.IOnCreate;
//import com.example.library.utils.L;
//
//
///**
// * 类描述：所有Fragment的基类
// * 创建人：liwei
// * 创建时间：2016/7/6 10:29
// */
//public abstract class BaseFragment extends Fragment
//        implements IOnCreate, IBaseView {
//
//    private View mRootView;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        if(mRootView!=null){
//            // 缓存的rootView需要判断是否已经被加过parent，
//            // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
//            ViewGroup parent = (ViewGroup) mRootView.getParent();
//            if (parent != null) {
//                parent.removeView(mRootView);
//            }
//
//        }else {
//            if(bindLayout()!=0){
//                mRootView = inflater.inflate(bindLayout(), null);
//            }else {
//                L.e(this+"--->bindLayout() return 0");
//            }
////            ButterKnife.bind(this, mRootView);
//            initVariables();
//            initViews(savedInstanceState);
//        }
//
//        return mRootView;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        loadData();
//    }
//    public View getmRootView(){
//        return mRootView;
//    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }
//
//    @Override
//    public void initVariables() {
//
//    }
//
//    @Override
//    public void loadData() {
//
//    }
//
//    @Override
//    public void showLoading() {
////        getBaseActivity().showLoading();
//    }
//
//    @Override
//    public void hideLoading() {
////        getBaseActivity().hideLoading();
//    }
//
//    protected BaseActivity getBaseActivity(){
//        if (getActivity() instanceof BaseActivity){
//            return (BaseActivity)getActivity();
//        }else {
//            throw new ClassCastException("activity must extends BaseActivity");
//        }
//    }
//
//    public void ShowSnackBar(@NonNull View view, String msg) {
//        //Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
//        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
//    }
//
//    protected void pushFragment(BaseFragment fragment){
////        getBaseActivity().pushFragment(fragment);
//    }
//
//    protected void popFragment(){
////        getBaseActivity().popFragment();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
////        ButterKnife.unbind(this);
//    }
//
//    @Override
//    public String toString() {
//        return getClass().getSimpleName();
//    }
//}
