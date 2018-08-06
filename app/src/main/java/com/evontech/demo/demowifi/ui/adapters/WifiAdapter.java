package com.evontech.demo.demowifi.ui.adapters;

import android.databinding.DataBindingUtil;
import android.net.wifi.ScanResult;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evontech.demo.demowifi.R;
import com.evontech.demo.demowifi.databinding.WifiLayoutBinding;
import com.evontech.demo.demowifi.ui.adapters.wifiadapter.WifiScanItemViewModel;
import com.evontech.demo.demowifi.ui.wifiscan.WifiScanViewModel;

import java.util.List;

public class WifiAdapter extends RecyclerView.Adapter<WifiAdapter.MyRecyclerView> {

    WifiLayoutBinding mwiWifiLayoutBinding;

    private List<ScanResult> mScanResults = null;
    public WifiAdapter( List<ScanResult> mScanResults){
        this.mScanResults = mScanResults;
    }

    @NonNull
    @Override
    public MyRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wifi_layout, parent, false);
        return new MyRecyclerView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerView holder, int position) {
        ScanResult scan_data = mScanResults.get(position);
        if(scan_data != null){

        }
    }

    @Override
    public int getItemCount() {
        return mScanResults.size();
    }

    class MyRecyclerView extends RecyclerView.ViewHolder{

        public MyRecyclerView(View itemView) {
            super(itemView.getRootView());
            bind();
        }

        private void bind(){
            if(mwiWifiLayoutBinding == null)
                mwiWifiLayoutBinding = DataBindingUtil.bind(itemView);
        }

        private void unBind(){
            if(mwiWifiLayoutBinding != null)
                mwiWifiLayoutBinding.unbind();
        }

        void setViewModel(WifiScanItemViewModel mWifiScanViewModel){
            if(mwiWifiLayoutBinding != null)
                mwiWifiLayoutBinding.setWifiScanData(mWifiScanViewModel);
        }
    }
}


