package com.abdelrahman.raafaat.learndi;

import com.abdelrahman.raafaat.learndi.model.Suager;

import dagger.Module;
import dagger.Provides;

@Module
public class CoffeeModule {

    @Provides
    Suager provideSuager() {
        return new Suager();
    }
}
