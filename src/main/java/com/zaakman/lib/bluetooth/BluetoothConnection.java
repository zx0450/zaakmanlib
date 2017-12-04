package com.zaakman.lib.bluetooth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by ZaakMan on 2017/11/23.
 */

public class BluetoothConnection {


    private BluetoothAdapter mAdapter;
    private Activity mActivity;
    public static final int REQUEST_BLE_ENABLE = 4001;

    @SuppressLint("MissingPermission")
    public BluetoothConnection(Activity activity){
        mActivity = activity;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mAdapter.isEnabled()){
            Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            mActivity.startActivityForResult(enabler, REQUEST_BLE_ENABLE);
        }
    }

}
