package com.abdelrahman.raafaat.learndi.model;

import android.util.Log;

import com.abdelrahman.raafaat.learndi.annotations.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class CoffeeType {

    private static final String TAG = "Abdo-----------CoffeeType";

    @Inject
    public CoffeeType() {
        Log.i(TAG, "CoffeeType: ");
    }

    public String getCoffeeType() {
        Log.i(TAG, "getCoffeeType: ");
        return "CoffeeType";
    }
}
