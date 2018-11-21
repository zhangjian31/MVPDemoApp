package com.jeryzhang.mvp.view.model;


import com.jeryzhang.mvp.view.contract.CustomViewContract;


public class CustomModel implements CustomViewContract.Model {
    @Override
    public String check(String s1, String s2) {
        return s1 + s2;
    }
}
