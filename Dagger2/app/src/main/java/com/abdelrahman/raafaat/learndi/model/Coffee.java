package com.abdelrahman.raafaat.learndi.model;

import android.util.Log;

import com.abdelrahman.raafaat.learndi.annotations.ActivityScope;
import com.abdelrahman.raafaat.learndi.annotations.Milk;

import javax.inject.Inject;
import javax.inject.Named;

@ActivityScope
public class Coffee {

    private static final String TAG = "Abdo-----------Coffee";

    @Inject
    public Farm farm;

    @Inject
    public River river;

    public CoffeeType coffeeType;
    private int sugar;
    private int milk;
//    @Inject
//    public Coffee(Farm farm, River river) {
//        this.farm = farm;
//        this.river = river;
//        Log.i(TAG, "Coffee: with params farm and river");
//    }


//    @Inject
//    public Coffee() {
//        Log.i(TAG, "Coffee: without params");
//    }

    @Inject
    public Coffee(CoffeeType coffeeType, @Named("sugar") int sugar, @Milk  int milk) {
        this.coffeeType = coffeeType;
        this.sugar = sugar;
        this.milk = milk;
        Log.i(TAG, "Coffee: with params coffeeType, sugar and milk");
    }


    @Inject
    public void openTheShop() {
        Log.i(TAG, "openTheShop: --------------------------");
    }

    @Inject
    public void connectElectric() {
        Log.i(TAG, "connectElectric: connecting..............");
    }

    @Inject
    public void cleanTheShop() {
        Log.i(TAG, "cleanTheShop: --------------------------");
    }

    ;

    public String getCoffeeInfo() {
        Log.i(TAG, "getCoffeeInfo: ");
        String coffeeInfo = "farm: " + farm.getBeans() + "river: " + river.getWater()
                + "coffeeType: " + coffeeType.getCoffeeType() + " sugar: " + sugar
                + " milk " + milk;
        Log.i(TAG, "getCoffeeInfo: " + coffeeInfo);
        return coffeeInfo;
    }
}
