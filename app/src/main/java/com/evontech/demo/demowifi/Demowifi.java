package com.evontech.demo.demowifi;

import android.app.Activity;
import android.app.Application;

import com.evontech.demo.demowifi.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class Demowifi extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

//    @Inject
//    CalligraphyConfig mCalligraphyConfig;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

//        AppLogger.init();

//        AndroidNetworking.initialize(getApplicationContext());
//        if (BuildConfig.DEBUG) {
//            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
//        }
//
//        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }
}
