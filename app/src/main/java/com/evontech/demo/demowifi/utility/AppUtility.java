package com.evontech.demo.demowifi.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.evontech.demo.demowifi.ui.listeners.WiFiScanListener;

import java.util.List;

public class AppUtility {

    WifiManager mWifiManager;
    private final String TAG = getClass().getSimpleName();
    private  WiFiScanListener listener = null;

    public void getWifiList(Context context, WiFiScanListener listener){
        mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        this.listener = listener;
        context.registerReceiver(mWifiScanReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mWifiManager.startScan();

    }


    private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                List<ScanResult> mScanResults = mWifiManager.getScanResults();
                // add your logic here
                Log.e(TAG, ""+mScanResults);
                if (listener!=null)
                    listener.onScanCompleted(mScanResults);
            }
        }
    };


    public String connectToWifiUsingPin(){
        try {
            Thread.sleep(1000);
            return "from thread";
        }catch (Exception exp){
            exp.printStackTrace();
            return  "in catch";
        }
    }
}
