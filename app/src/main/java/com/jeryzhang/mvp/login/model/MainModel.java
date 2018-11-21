package com.jeryzhang.mvp.login.model;

import com.jeryzhang.mvp.login.contract.MainContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainModel implements MainContract.Model {

    @Override
    public void login(final String userName, final String pwd, final OnLoginListener onLoginListener) {
        Disposable disposable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) {
                e.onNext(userName + " 登录成功");
                e.onComplete();
            }
        }).delay(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        if ("abc".equals(userName) && "123".equals(pwd)) {
                            onLoginListener.onSuccess(s);
                        } else {
                            onLoginListener.onFail();
                        }

                    }
                });
    }

    @Override
    public void logout() {

    }
}
