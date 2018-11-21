package com.jeryzhang.mvp.login.view;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jeryzhang.mvp.R;
import com.jeryzhang.mvp.base.BaseMvpActivity;
import com.jeryzhang.mvp.login.contract.MainContract;
import com.jeryzhang.mvp.login.presenter.MainPresenter;
import com.jeryzhang.mvp.view.view.CustomView;


public class LoginActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View, View.OnClickListener {
    private ProgressBar progressBar;
    private Button mLoginBtn;
    private EditText mUserNameEt;
    private EditText mPwdEt;
    private CustomView mCustomView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        progressBar = findViewById(R.id.progressbar);
        mLoginBtn = findViewById(R.id.login);
        mUserNameEt = findViewById(R.id.et_username);
        mPwdEt = findViewById(R.id.et_pwd);
        mCustomView = findViewById(R.id.customview);
    }

    @Override
    protected void initListener() {
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mCustomView.startCheck("Hello ", "world");
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void loginSuccess(String msg) {
        Toast.makeText(LoginActivity.this, msg + "\r\nloginSuccess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(LoginActivity.this, "loginFail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            mPresenter.doLogin(mUserNameEt.getText().toString(), mPwdEt.getText().toString());
        }
    }
}
