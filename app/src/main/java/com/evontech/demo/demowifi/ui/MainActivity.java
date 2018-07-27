package com.evontech.demo.demowifi.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.evontech.demo.demowifi.R;
import com.evontech.demo.demowifi.ui.adapters.WifiAdapter;
import com.evontech.demo.demowifi.ui.listeners.WiFiScanListener;
import com.evontech.demo.demowifi.utility.AppUtility;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WiFiScanListener {

    private RecyclerView recycler_wifi = null;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private WifiAdapter mAdapter = null;
    private List<ScanResult> mScanResults = new ArrayList<>();
    private FloatingActionButton floating_scan_button = null;
    private ConstraintLayout coordinatorLayout = null;
    private  Snackbar snackbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_wifi = findViewById(R.id.recycler_wifi);
        floating_scan_button = findViewById(R.id.floating_scan_button);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        askForPermission(Manifest.permission.ACCESS_FINE_LOCATION, MY_PERMISSIONS_REQUEST_LOCATION);
    }

    private void init(){


        AppUtility appUtility = new AppUtility();
        appUtility.getWifiList(this, this);
        mAdapter = new WifiAdapter(mScanResults);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_wifi.setLayoutManager(mLayoutManager);
        recycler_wifi.setItemAnimator(new DefaultItemAnimator());
        recycler_wifi.setAdapter(mAdapter);

        floating_scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScan();

            }
        });
    }


    private void startScan(){
        snackbar = Snackbar
                .make(coordinatorLayout, "Scanning Network Please Wait", Snackbar.LENGTH_LONG);

        snackbar.show();
        mScanResults.clear();
        mAdapter.notifyDataSetChanged();
        askForPermission(Manifest.permission.ACCESS_FINE_LOCATION, MY_PERMISSIONS_REQUEST_LOCATION);
    }





    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
            }
        } else {
//            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
}                       init();

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    Toast.makeText(this,
                            "App can not work without location permission",
                            Toast.LENGTH_LONG);

                }
                return;
            }

        }
    }

    @Override
    public void onScanCompleted(List<ScanResult> mScanResults) {

        this.mScanResults.clear();
        this.mScanResults.addAll(mScanResults);
        mAdapter.notifyDataSetChanged();

        if(snackbar != null && snackbar.isShown()){
            snackbar.dismiss();
        }
    }
}
