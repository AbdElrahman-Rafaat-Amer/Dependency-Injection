package com.abdelrahman.raafaat.learndi;

import com.abdelrahman.raafaat.learndi.model.CoffeeType;

import dagger.Module;
import dagger.Provides;

@Module
public class CoffeeTypeModule {

    @Provides
    CoffeeType provideCoffeeType() {
        return new CoffeeType();
    }

}
