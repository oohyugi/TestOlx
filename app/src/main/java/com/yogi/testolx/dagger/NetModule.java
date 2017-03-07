package com.yogi.testolx.dagger;

import com.yogi.ApiClient;
import com.yogi.testolx.GetAllDataActivityPresenter;
import com.yogi.testolx.GetAllDataActivityView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yogi on 07/03/17.
 */

@Module
public class NetModule{

@Provides
@Singleton
public ApiClient provideClient(){
    return new ApiClient("");
}



}
