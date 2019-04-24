package com.example.bill.mvvm_demo.View;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bill.mvvm_demo.R;
import com.example.bill.mvvm_demo.databinding.ActivityMainBinding;
import com.example.bill.mvvm_demo.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private MainViewModel viewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

    }
}
