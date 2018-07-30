package com.evontech.demo.demowifi.ui.wifiscan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.evontech.demo.demowifi.R;
import com.evontech.demo.demowifi.BR;
import com.evontech.demo.demowifi.databinding.ActivityWifiScanBinding;
import com.evontech.demo.demowifi.ui.base.BaseActivity;
import com.evontech.demo.demowifi.ui.base.BaseViewModel;

import javax.inject.Inject;

public class WifiScan extends BaseActivity<ActivityWifiScanBinding, WifiScanViewModel> implements WifiScanNavigator {

    @Inject
    WifiScanViewModel mWifiScanViewModel;

    private ActivityWifiScanBinding mActivityWifiScanBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, WifiScan.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_wifi_scan;
    }

    @Override
    public WifiScanViewModel getViewModel() {
        return mWifiScanViewModel;
    }
}
