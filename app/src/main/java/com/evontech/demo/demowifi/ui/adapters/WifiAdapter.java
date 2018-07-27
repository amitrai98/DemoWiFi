package com.evontech.demo.demowifi.ui.adapters;

import android.net.wifi.ScanResult;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evontech.demo.demowifi.R;

import java.util.List;

public class WifiAdapter extends RecyclerView.Adapter<WifiAdapter.MyRecyclerView> {

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
            holder.txtNetworkName.setText("Network Name : "+scan_data.SSID);
            holder.txtNetworkStrength.setText("Frequency : "+scan_data.frequency);
            holder.txtNetworkfreq.setText("ChanelBandWidth : "+scan_data.channelWidth);
            holder.txtchannelWidth.setText("Center Frequency : "+scan_data.centerFreq0);
            holder.txtCenterFreq.setText("Level : "+scan_data.level);
            holder.txtBssid.setText("Chanel Frequency : "+scan_data.centerFreq1);
            holder.txtCapabilities.setText("Capablities : "+scan_data.capabilities);

        }
    }

    @Override
    public int getItemCount() {
        return mScanResults.size();
    }

    class MyRecyclerView extends RecyclerView.ViewHolder{
        ImageView imgWifi;
        TextView txtNetworkName, txtNetworkStrength, txtNetworkfreq, txtchannelWidth, txtCenterFreq, txtBssid , txtCapabilities;
        public MyRecyclerView(View itemView) {
            super(itemView);
            txtNetworkName = itemView.findViewById(R.id.txtNetworkName);
            txtNetworkStrength = itemView.findViewById(R.id.txtNetworkStrength);
            txtNetworkfreq = itemView.findViewById(R.id.txtNetworkfreq);
            txtchannelWidth = itemView.findViewById(R.id.txtchannelWidth);
            txtCenterFreq = itemView.findViewById(R.id.txtCenterFreq);
            txtBssid = itemView.findViewById(R.id.txtBssid);
            txtCapabilities = itemView.findViewById(R.id.txtCapabilities);
        }
    }
}


