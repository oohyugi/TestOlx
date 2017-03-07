package com.yogi.testolx;


import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.yogi.model.BaseDao;
import com.yogi.model.ItemArray;

public class GetAllDataActivity extends AppCompatActivity implements GetAllDataActivityView {

    ProgressDialog  progressDialog;
    public static String TAG = "GetAllDataActivity";
    GetAllDataActivityPresenter mPresenter;
    RecyclerView mRecycleListView;
    RecyclerView.LayoutManager mLayoutManager;
    ListAdapter mAdapter;


    public static void startThisActivity(Context mContext) {
        Intent intent = new Intent(mContext, GetAllDataActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_data);
        mRecycleListView =(RecyclerView) findViewById(R.id.recycleview);
        mPresenter = new GetAllDataActivityPresenter(this);
        mPresenter.loadDataFromServer();


    }

    @Override
    public void onDataLoaded(BaseDao<ItemArray> data) {
        progressDialog.dismiss();
        setvalueList(data);

    }

    private void setvalueList(BaseDao<ItemArray> data) {
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ListAdapter(this, data.ItemArray.Item, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        mRecycleListView.setLayoutManager(mLayoutManager);
        mRecycleListView.setAdapter(mAdapter);

    }

    @Override
    public void showProgressDialog() {

        progressDialog = ProgressDialog.show(this,null,"Please wait..");
        progressDialog.show();

    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();

    }

    @Override
    public void errorProgressDialog(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
