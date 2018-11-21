package  com.jeryzhang.mvp.login.contract;

import com.jeryzhang.mvp.base.mvp.IModel;
import com.jeryzhang.mvp.base.mvp.IPresenter;
import com.jeryzhang.mvp.base.mvp.IView;


public interface MainContract {
    interface Model extends IModel {
        void login(String userName, String pwd, OnLoginListener onLoginListener);

        void logout();

        interface OnLoginListener {
            void onSuccess(String msg);

            void onFail();
        }
    }

    interface View extends IView {
        void loginSuccess(String msg);

        void loginFail();
    }

    interface Presenter extends IPresenter {
        void doLogin(String userName, String pwd);

        void doLogout();
    }
}
