package com.abdelrahman.raafaat.learndi.model;

import android.util.Log;


public class Farm {
    private static final String TAG = "Abdo-----------Farm";

    //Note this class is exapmle for non modified class like Retorfit, ViewModel or any other thirdPartyLibreries
    public Farm() {
        Log.i(TAG, "Farm: ");
    }

    public String getBeans(){
        Log.i(TAG, "getBeans: ");
        return "Beans";
    }
}
