package com.abdelrahman.raafaat.learndi.model;

import android.util.Log;

import javax.inject.Inject;

public class Farm {
    private static final String TAG = "Abdo-----------Farm";

    @Inject
    public Farm() {
        Log.i(TAG, "Farm: ");
    }

    public String getBeans(){
        Log.i(TAG, "getBeans: ");
        return "Beans";
    }
}
