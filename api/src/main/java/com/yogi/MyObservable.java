package com.yogi;

import rx.Subscriber;

/**
 * Created by yogi on 04/03/17.
 */
public abstract class MyObservable<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onError(e.getMessage());
    }

    protected abstract void onError(String message);

    @Override
    public void onNext(T t) {
        onSucces(t);
    }

    protected abstract void onSucces(T t);
}