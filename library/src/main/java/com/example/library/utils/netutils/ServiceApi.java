//package com.example.library.utils.netutils;
//
//import com.example.library.utils.L;
//
//import retrofit2.Retrofit;
//import retrofit2.http.GET;
//import rx.Observable;
//import rx.Subscriber;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;
//
///**
// * Created by liwei on 2016/11/15.
// */
//
//public interface ServiceApi {
////
////    @GET("stream/")
////    Observable<Mydata> getHomeData();
////String baseUrl = "http://ic.snssdk.com/api/2/article/v25/";
////    Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(baseUrl);
////    ServiceApi api = retrofit.create(ServiceApi.class);
////    api.getHomeData()
////            .subscribeOn(Schedulers.io())
////            .observeOn(AndroidSchedulers.mainThread())
////            .subscribe(new Subscriber<Mydata>() {
////        @Override
////        public void onCompleted() {
////
////        }
////
////        @Override
////        public void onError(Throwable e) {
////            L.e(e.toString());
////        }
////
////        @Override
////        public void onNext(Mydata homeBean) {
////            L.e(homeBean.wenda_extra+homeBean.has_more+homeBean.total_number
////                    +homeBean.show_et_status
////            );
////        }
////    });
//}
