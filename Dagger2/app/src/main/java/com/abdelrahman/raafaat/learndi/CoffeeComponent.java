package com.abdelrahman.raafaat.learndi;

import com.abdelrahman.raafaat.learndi.annotations.ActivityScope;
import com.abdelrahman.raafaat.learndi.annotations.Milk;
import com.abdelrahman.raafaat.learndi.model.Coffee;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface CoffeeComponent {

    Coffee getCoffee();
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder setSugar(@Named("sugar") int sugar);

        @BindsInstance
        Builder setMilk(@Milk int milk);


        Builder setAppCompenent(AppComponent appCompenent);

        CoffeeComponent buildCoffeeComponent();
    }
}
