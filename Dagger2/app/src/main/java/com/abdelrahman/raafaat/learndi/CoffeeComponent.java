package com.abdelrahman.raafaat.learndi;

import com.abdelrahman.raafaat.learndi.annotations.Milk;
import com.abdelrahman.raafaat.learndi.model.Coffee;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = CoffeeTypeModule.class)
public interface CoffeeComponent {

    Coffee getCoffee();
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder setSugar(@Named("sugar") int sugar);

        @BindsInstance
        Builder setMilk(@Milk int milk);


        CoffeeComponent buildCoffeeComponent();
    }
}
