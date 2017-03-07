package com.yogi.testolx;


import android.util.Log;

import com.yogi.ApiClient;
import com.yogi.MyObservable;
import com.yogi.model.BaseDao;
import com.yogi.model.ItemArray;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetAllDataActivityPresenter {
    GetAllDataActivityView mView;
    ApiClient mClient;

    public GetAllDataActivityPresenter(GetAllDataActivityView mView) {
        this.mView =mView;
        mClient = new ApiClient("http://open.api.ebay.com/");



    }

    public void loadDataFromServer() {

        mView.showProgressDialog();
        mClient.getmServices().getData("FindPopularItems","JSON","FandyGot-ec13-4906-b11c-94d9e36684ee",0,"dog","713")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObservable<BaseDao<ItemArray>>() {

                    @Override
                    protected void onError(String message) {
                    mView.hideProgressDialog();
                        mView.errorProgressDialog(message);
                        Log.e( "onError: ", message);
                    }

                    @Override
                    protected void onSucces(BaseDao<ItemArray> itemArrayBaseDao) {
                        mView.hideProgressDialog();
                        mView.onDataLoaded(itemArrayBaseDao);
                        Log.e("onSucces: ",itemArrayBaseDao.Ack );

                    }
                });

    }

}
