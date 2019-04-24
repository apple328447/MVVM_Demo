package com.example.bill.mvvm_demo.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.example.bill.mvvm_demo.Model.DataModel;

/**
 * ViewModel：接收View的指令並對Model請求資料，將取得的資料保存起來供View使用。
 *
 * 此時就是MVVM和MVP最不同的地方，ViewModel並不使用callback的方式來通知View，
 * 而是用Observer pattern的概念，由View來訂閱(subscribe)ViewModel中它要的資料，
 * 並在資料異動時才更新UI，因此，MVVM都會搭配如Data Binding等library來實現Observer pattern。
 * */

public class MainViewModel {
    //這是存資料
    //用Data Binding中的Observable來讓View和ViewModel溝通。
    public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    public final ObservableField<String> description = new ObservableField<>("隨機產生一組數字");


    private DataModel dataModel = new DataModel();

    public void refresh() {

        isLoading.set(true);
        mData.set("");
        dataModel.retrieveData(new DataModel.onDataReadyCallback() {
            @Override
            public void onDataReady(String data,Boolean loading) {
                mData.set(data);
                isLoading.set(loading);
            }
        });
    }

    public void refresh2(){
        mData.set("");
        mData.set(dataModel.updateText());
    }
}