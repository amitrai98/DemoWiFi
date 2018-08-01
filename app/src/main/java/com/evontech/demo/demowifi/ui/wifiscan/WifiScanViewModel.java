package com.evontech.demo.demowifi.ui.wifiscan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.util.Log;

import com.evontech.demo.demowifi.Demowifi;
import com.evontech.demo.demowifi.ui.base.BaseViewModel;
import com.evontech.demo.demowifi.ui.listeners.WiFiScanListener;
import com.evontech.demo.demowifi.utility.AppUtility;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.schedulers.Schedulers;

public class WifiScanViewModel extends BaseViewModel<WifiScanNavigator> implements WiFiScanListener{
    private final String TAG = WifiScanViewModel.class.getName();

    public WifiScanViewModel() {
        super();
    }

    @Inject
    Demowifi mWifiscan;

    @SuppressLint("CheckResult")
    public void scanWifiNetworks(){
        Log.e(TAG, "i was called");

        Observable.fromCallable(() -> {

            try {
                AppUtility utility = new AppUtility();
                utility.getWifiList(mWifiscan.getApplicationContext(), WifiScanViewModel.this);
                return "executed";
            } catch (Exception e) {
                Log.e("Network request", "Failure", e);
                return "exception";
            }


        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    //Use result for something
                    Log.e(TAG, ""+result);
                    setAdapter(result);
                });

    }


    private <T> void setAdapter(T result){
        Log.e(TAG, "time to set data in adapter"+result);
    }

    @Override
    public void onScanCompleted(List<ScanResult> mScanResults) {
        Log.e(TAG, "scan received");
    }
}
