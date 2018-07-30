package com.evontech.demo.demowifi.ui.wifiscan;

import android.util.Log;

import com.evontech.demo.demowifi.ui.base.BaseViewModel;

public class WifiScanViewModel extends BaseViewModel<WifiScanNavigator> {
    private final String TAG = WifiScanViewModel.class.getName();

    public WifiScanViewModel() {
        super();
    }

    public void scanWifiNetworks(){
        Log.e(TAG, "i was called");
        getCompositeDisposable().add(Ap)
    }
}
