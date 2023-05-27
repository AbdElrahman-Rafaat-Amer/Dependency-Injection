package com.abdelrahman.raafaat.learndi.modules;

import com.abdelrahman.raafaat.learndi.model.River;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RiverModule {

    @Singleton
    @Provides
    River provideRiver() {
        return new River();
    }

}
