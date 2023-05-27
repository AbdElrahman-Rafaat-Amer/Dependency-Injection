package com.abdelrahman.raafaat.learndi;

import android.app.Application;

public class MainApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
