package com.abdelrahman.raafaat.learndi.model;

import android.util.Log;


public class River {

    private static final String TAG = "Abdo-----------River";

    //Note this class is exapmle for non modified class like Retorfit, ViewModel or any other thirdPartyLibreries
    public River() {
        Log.i(TAG, "River: ");
    }

    public String getWater(){
        Log.i(TAG, "getWater: ");
        return "Water";
    }
}
