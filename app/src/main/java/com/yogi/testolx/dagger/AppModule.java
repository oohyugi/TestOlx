package com.yogi.testolx.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yogi on 07/03/17.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }
    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }
}
