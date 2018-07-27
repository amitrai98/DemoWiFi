package com.evontech.demo.demowifi.ui.listeners;

import android.net.wifi.ScanResult;

import java.util.List;

public interface WiFiScanListener {
    public void onScanCompleted(List<ScanResult> mScanResults);
}
