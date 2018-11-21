package  com.jeryzhang.mvp.login.presenter;


import com.jeryzhang.mvp.base.mvp.BasePresenter;
import com.jeryzhang.mvp.login.contract.MainContract;
import com.jeryzhang.mvp.login.model.MainModel;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }


    @Override
    public void doLogin(String userName, String pwd) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();

        model.login(userName, pwd, new MainContract.Model.OnLoginListener() {
            @Override
            public void onSuccess(String msg) {
                mView.loginSuccess(msg);
                mView.hideLoading();
            }

            @Override
            public void onFail() {
                mView.loginFail();
                mView.hideLoading();
            }
        });
    }


    @Override
    public void doLogout() {

    }
}
