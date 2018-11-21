package com.jeryzhang.mvp.view.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jeryzhang.mvp.view.contract.CustomViewContract;
import com.jeryzhang.mvp.view.presenter.CustomPresenter;

public class CustomView extends FrameLayout implements CustomViewContract.View {
    private CustomPresenter presenter;
    private Context context;
    private TextView tipsView;
    private ProgressBar progressBar;

    public CustomView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(Color.YELLOW);
        this.context = context;
        presenter = new CustomPresenter();
        presenter.attachView(this);

        tipsView = new TextView(this.context);
        tipsView.setGravity(Gravity.CENTER);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(tipsView, params);

        progressBar = new ProgressBar(context);
        params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(progressBar, params);

        progressBar.setVisibility(GONE);

    }

    public void startCheck(String s1, String s2) {
        presenter.doCheck(s1, s2);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(GONE);
    }

    @Override
    public void success(String result) {
        tipsView.setText(result);
    }

    @Override
    public void fail() {
        tipsView.setText("");
    }
}
