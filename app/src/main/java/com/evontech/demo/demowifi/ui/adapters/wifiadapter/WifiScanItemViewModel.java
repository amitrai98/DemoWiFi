package com.evontech.demo.demowifi.ui.adapters.wifiadapter;

import android.net.wifi.ScanResult;

import com.evontech.demo.demowifi.ui.base.BaseViewModel;
import com.evontech.demo.demowifi.ui.wifiscan.WifiScanNavigator;
import com.evontech.demo.demowifi.ui.wifiscan.WifiScanViewModel;

import java.util.List;

public class WifiScanItemViewModel extends BaseViewModel<WifiScanNavigator> {
    private final String TAG = WifiScanViewModel.class.getName();

    private ScanResult scanResult;

    public WifiScanItemViewModel(ScanResult scanResult) {
        this.scanResult = scanResult;
    }


}
