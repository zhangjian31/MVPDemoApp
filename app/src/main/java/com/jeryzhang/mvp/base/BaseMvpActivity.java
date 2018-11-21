package com.jeryzhang.mvp.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jeryzhang.mvp.base.mvp.BasePresenter;
import com.jeryzhang.mvp.base.mvp.IView;


public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements IView {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachView(this);
        super.onCreate(savedInstanceState);
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}
