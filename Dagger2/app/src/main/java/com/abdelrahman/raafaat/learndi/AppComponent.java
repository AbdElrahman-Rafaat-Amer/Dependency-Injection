package com.abdelrahman.raafaat.learndi;

import com.abdelrahman.raafaat.learndi.model.Farm;
import com.abdelrahman.raafaat.learndi.model.River;
import com.abdelrahman.raafaat.learndi.modules.FarmModule;
import com.abdelrahman.raafaat.learndi.modules.RiverModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RiverModule.class, FarmModule.class})
public interface AppComponent {

    River getRiver();

    Farm getFarm();

}
