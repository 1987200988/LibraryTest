//package com.example.library.mvp;
//
//
//
//
//import com.example.library.mvp.ibase.IBaseModel;
//import com.example.library.utils.netutils.ICallback;
//import com.example.library.utils.netutils.ResponseBean;
//
//import java.net.SocketTimeoutException;
//import java.util.List;
//
//import rx.Observable;
//import rx.Subscriber;
//import rx.Subscription;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;
//
///**
// * 类描述：
// * 创建人：liwei
// * 创建时间：2016/7/11 13:29
// */
//public abstract class BaseModel<E> implements IBaseModel {
//    private E api;
//    private Subscription mSubscription;
//    private Subscription mSubscriptionList;
//    private Observable threadControl(Observable observable){
//        return observable
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io());
//    }
//
//    public void setApi(E api) {
//        this.api = api;
//    }
//
//    public E getApi() {
//        return api;
//    }
//
//    private Subscription subscribe(Observable observable,
//                                   final ICallback callback){
//        return observable
//                .subscribe(new Subscriber<ResponseBean>() {
//                        @Override
//                        public void onCompleted() {
//                        }
//
//                        @Override
//                    public void onError(Throwable e) {
//                        if(callback!=null){
//                            if(e instanceof SocketTimeoutException)
//                                callback.onFailed("服务器异常");
//                            else
//                                callback.onFailed(e.getMessage());
//                        }
//
//                    }
//                    @Override
//                    public void onNext(ResponseBean response) {
//                        if(callback!=null) {
//                                callback.onCompleted(response);
//                        }
//                    }
//                });
//    }
//    private Subscription subscribeList(Observable observable,
//                                   final ICallback callback){
//        return observable
//                .subscribe(new Subscriber<List<ResponseBean>>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if(callback!=null){
//                            if(e instanceof SocketTimeoutException)
//                                callback.onFailed("服务器异常");
//                            else
//                                callback.onFailed(e.getMessage());
//                        }
//
//                    }
//                    @Override
//                    public void onNext(List<ResponseBean> response) {
//                        if(callback!=null) {
//                            callback.onCompleted(response);
//                        }
//                    }
//                });
//    }
//
//    protected Subscription deploy(Observable observable, final ICallback callback){
//        mSubscription = subscribe(threadControl(observable),callback);
//        return mSubscription;
//    }
//    protected Subscription deployList(Observable observable,final ICallback callback){
//       mSubscriptionList =subscribeList(threadControl(observable),callback);
//        return mSubscriptionList;
//
//    }
//
//
//
//
//    @Override
//    public void onDestroy() {
//        if (null != mSubscription && mSubscription.isUnsubscribed()) {
//            mSubscription.unsubscribe();
//        }
//    }
//}
