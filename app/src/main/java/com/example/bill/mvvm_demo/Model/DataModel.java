package com.example.bill.mvvm_demo.Model;


import android.os.Handler;

import java.util.Random;

/**
 * Model：管理資料來源如API和本地資料庫
 * */


public class DataModel {

    public void retrieveData(final onDataReadyCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDataReady(updateText(),false);//回傳
            }
        }, 500);
    }
    //Interface實作Call Back機制
    //http://andy02172001.blogspot.com/2017/10/androidinterfacecall-back.html
    public interface onDataReadyCallback {
        void onDataReady(String data,Boolean loading);
    }



    public String updateText(){
        int randomNumber = (int)((double)Math.random()*10);
        return Integer.toString(randomNumber);
    }
}