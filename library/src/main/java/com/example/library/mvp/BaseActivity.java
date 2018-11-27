//package com.example.library.mvp;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.content.res.Configuration;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.KeyEvent;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Toast;
//
//import com.example.library.mvp.ibase.IActivity;
//import com.example.library.mvp.ibase.IBaseView;
//
//
///**
// * 类描述：所有子Activity的基类
// * 创建人：liwei
// * 创建时间：2016/7/6 10:13
// */
//public abstract class BaseActivity extends AppCompatActivity
//        implements IActivity,IBaseView {
//
//    private Dialog mLoadingDialog;
//    private Toolbar toolbar;
//    private View mContentView;
//
//    //由于有些跳转无需参数,所以这里无需抽象方法
//    protected void handleIntent(Intent intent) {
//
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//
//        beforeContentView();
//        //处理Intent(主要用来获取其中携带的参数)
//        if (getIntent() != null) {
//            handleIntent(getIntent());
//        }
//
//        if (bindLayout() != 0) {
//            mContentView = View.inflate(this,bindLayout(),null);
//            setContentView(mContentView);
//
//
//            initVariables();
//            initViews(savedInstanceState);
//            mLoadingDialog = getLoadingDialog();
//            setDisplayShowTitleEnabled(false);
//            loadData();
//        } else {
//
//
//        }
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    protected void setDisplayHomeAsUpEnabled(boolean flag) {
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            //actionBar.setHomeAsUpIndicator(R.drawable.back);
//        }
//    }
//
//    protected void setDisplayShowTitleEnabled(boolean flag) {
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayShowTitleEnabled(false);
//        }
//    }
//
//    protected Dialog getLoadingDialog() {
//        return null;
//    }
//
//    @Override
//    public void showLoading() {
//        if (mLoadingDialog != null && !mLoadingDialog.isShowing())
//            mLoadingDialog.show();
//    }
//
//    @Override
//    public void hideLoading() {
//        if (mLoadingDialog != null && mLoadingDialog.isShowing())
//            mLoadingDialog.dismiss();
//    }
//
//    @Override
//    public void beforeContentView() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
//    }
//
//    @Override
//    public void loadData() {
//
//    }
//
//    /**
//     * 重构findViewById
//     *
//     * @param viewId
//     * @param <T>
//     * @return
//     */
//    public <T extends View> T findView(int viewId) {
//        return (T) findViewById(viewId);
//    }
//
//    /**
//     * 如果需要添加fragment 需重写此方法提供FrameLayout的ID
//     *
//     * @return
//     */
//    protected int getFragmentContainerId() {
//        return 0;
//    }
//
//    /**
//     * 往activity中添加fragment
//     *
//     * @param fragment
//     */
//    public void pushFragment(BaseFragment fragment) {
//        if (fragment != null && getFragmentContainerId() != 0) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(getFragmentContainerId(), fragment)
//                    //.addToBackStack(fragment.toString())
//                    .commitAllowingStateLoss();
//        }
//    }
//
//    /**
//     * 从回退栈中抛出fragment
//     */
//    public void popFragment() {
//        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
//            getSupportFragmentManager().popBackStack();
//        } else {
//            finish();
//        }
//    }
//
//    public void ShowSnackBar(@NonNull View view, String msg) {
//        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
//    }
//    public void ShowToast(String msg) {
//        //Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
//        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (KeyEvent.KEYCODE_BACK == keyCode) {
//            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
//                finish();
//                return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    public void setSupportActionBar(@Nullable Toolbar toolbar) {
//        this.toolbar=toolbar;
//        super.setSupportActionBar(toolbar);
//    }
//
//    public Toolbar getToolbar(){
//        return toolbar;
//    }
//
//    public View getContentView() {
//        return mContentView;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            finish();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        hideLoading();
//
//        mContentView=null;
//
//    }
//}
