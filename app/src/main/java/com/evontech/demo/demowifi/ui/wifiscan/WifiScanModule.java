package com.evontech.demo.demowifi.ui.wifiscan;

import dagger.Module;
import dagger.Provides;

@Module
public class WifiScanModule {

    @Provides
    WifiScanViewModel provideWifiScanViewModel(){
        return new WifiScanViewModel();
    }

}
