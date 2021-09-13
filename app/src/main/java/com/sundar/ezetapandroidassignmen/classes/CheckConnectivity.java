package com.sundar.ezetapandroidassignmen.classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.sundar.ezetapandroidassignmen.language.Ezetap;

/**
 * Created by Sundar Chaupal (yr developer)on 03-09-2021.
 */
public class CheckConnectivity extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener;

    public CheckConnectivity() {
        super();
    }

    public static boolean isConnected() {

        ConnectivityManager cm = (ConnectivityManager) Ezetap.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    @Override
    public void onReceive(Context context, Intent arg1) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnected();

        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }
}