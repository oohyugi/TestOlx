package com.yogi.testolx;


import com.yogi.model.BaseDao;
import com.yogi.model.ItemArray;

import rx.Observable;

public interface GetAllDataActivityView {

    void onDataLoaded(BaseDao<ItemArray> data);
    void showProgressDialog();
    void hideProgressDialog();
    void errorProgressDialog(String message);
}
