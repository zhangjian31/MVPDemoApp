package com.jeryzhang.mvp.view.presenter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.jeryzhang.mvp.base.mvp.BasePresenter;
import com.jeryzhang.mvp.view.contract.CustomViewContract;
import com.jeryzhang.mvp.view.model.CustomModel;

public class CustomPresenter extends BasePresenter<CustomViewContract.View> implements CustomViewContract.Presenter {
    private CustomModel model;
    private Handler handler = new Handler(Looper.getMainLooper());

    public CustomPresenter() {
        model = new CustomModel();
    }

    @Override
    public void doCheck(final String s1, final String s2) {
        mView.showLoading();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                check(s1, s2);
            }
        }, 2000);
    }

    private void check(String s1, String s2) {
        String result = model.check(s1, s2);
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(result)) {
            mView.hideLoading();
            mView.fail();
        } else {
            mView.hideLoading();
            mView.success(result);
        }
    }
}
