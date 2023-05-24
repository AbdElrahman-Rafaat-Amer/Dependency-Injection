package com.abdelrahman.raafaat.learndi;

import com.abdelrahman.raafaat.learndi.model.Coffee;

import dagger.Component;

@Component(modules = CoffeeModule.class)
//@Component(modules = {CoffeeModule.class, AnotherModule.class})
public interface CoffeeComponent {

    Coffee getCoffee();
    void inject(MainActivity mainActivity);
}
