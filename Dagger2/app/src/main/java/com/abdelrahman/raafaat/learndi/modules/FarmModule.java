package com.abdelrahman.raafaat.learndi.modules;

import com.abdelrahman.raafaat.learndi.model.Farm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FarmModule {

    @Singleton
    @Provides
    Farm provideFarm() {
        return new Farm();
    }

}
