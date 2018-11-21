package com.jeryzhang.mvp.base.mvp;

public abstract class BasePresenter<V extends IView> implements IPresenter {
    protected V mView;

    public void attachView(V view) {
        this.mView = view;
    }


    public void detachView() {
        this.mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

}
