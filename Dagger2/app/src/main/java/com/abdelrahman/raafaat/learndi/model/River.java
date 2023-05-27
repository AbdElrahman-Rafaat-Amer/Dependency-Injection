package com.abdelrahman.raafaat.learndi.model;

import android.util.Log;

import javax.inject.Inject;

public class River {

    private static final String TAG = "Abdo-----------River";

    @Inject
    public River() {
        Log.i(TAG, "River: ");
    }

    public String getWater(){
        Log.i(TAG, "getWater: ");
        return "Water";
    }
}
