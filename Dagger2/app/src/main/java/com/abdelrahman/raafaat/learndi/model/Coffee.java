package com.abdelrahman.raafaat.learndi.model;

import android.util.Log;

import javax.inject.Inject;

import dagger.Provides;


public class Coffee {

    private static final String TAG = "Abdo-----------Coffee";
    @Inject
    Farm farm;
    @Inject
    River river;

//    private Suager suager;

//    @Inject
//    public Coffee(Farm farm, River river) {
//        this.farm = farm;
//        this.river = river;
//        Log.i(TAG, "Coffee: with params farm and river");
//    }

    @Inject
    public Coffee() {
        Log.i(TAG, "Abdo Coffee: without params");
    }

//    @Inject
//    public Coffee(Suager suager) {
//        this.suager = suager;
//        Log.i(TAG, "Coffee: with params suager");
//    }

    public void connectElectric() {
        Log.i(TAG, "connectElectric: connecting..............");
    }

    public String getCoffeeInfo() {
        return farm.getBeans() + river.getWater();
    }
}
