package com.abdelrahman.raafaat.learndi;

import com.abdelrahman.raafaat.learndi.annotations.ActivityScope;
import com.abdelrahman.raafaat.learndi.annotations.Milk;
import com.abdelrahman.raafaat.learndi.model.Coffee;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface CoffeeComponent {

    Coffee getCoffee();
    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder{

        @BindsInstance
        Builder setSugar(@Named("sugar") int sugar);

        @BindsInstance
        Builder setMilk(@Milk int milk);

        CoffeeComponent buildCoffeeComponent();
    }
}
