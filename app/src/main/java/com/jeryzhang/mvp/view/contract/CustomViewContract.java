package com.jeryzhang.mvp.view.contract;

import com.jeryzhang.mvp.base.mvp.IModel;
import com.jeryzhang.mvp.base.mvp.IPresenter;
import com.jeryzhang.mvp.base.mvp.IView;

public class CustomViewContract {
    public interface Model extends IModel {
        String check(String s1, String s2);
    }

    public interface View extends IView {
        void success(String result);

        void fail();

    }

    public interface Presenter extends IPresenter {
        void doCheck(String s1, String s2);
    }
}
