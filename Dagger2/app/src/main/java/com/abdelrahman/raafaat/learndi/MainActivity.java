package com.abdelrahman.raafaat.learndi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.abdelrahman.raafaat.learndi.model.Coffee;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Abdo-----------MainActivity";

    @Inject
    Coffee coffee, coffee2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        CoffeeComponent coffeeComponent  = DaggerCoffeeComponent.create();
//        CoffeeComponent coffeeComponent  = DaggerCoffeeComponent.builder().coffeeTypeModule(new CoffeeTypeModule(18657480)).build();

        AppComponent appComponent = ((MainApplication) getApplication()).getAppComponent();
        CoffeeComponent coffeeComponent  = DaggerCoffeeComponent.builder().setAppCompenent(appComponent).setSugar(7).setMilk(102).buildCoffeeComponent();

        /**
         *This is an example how to provide an object of Coffee class without using Filed injection to Coffee class
         */
//         coffeeComponent.getCoffee().getCoffeeInfo();


        Log.i(TAG, "onCreate: ==============================================================================================");
        coffeeComponent.inject(this);
        coffee.getCoffeeInfo();
        Log.i(TAG, "Scope onCreate: \ncoffee: " + coffee + "\ncoffee2: " + coffee2);
        Log.i(TAG, "Scope onCreate: \nriver1: " + coffee.river + "\nriver2: " + coffee2.river);
        Log.i(TAG, "Scope onCreate: \nfarm1: " + coffee.farm + "\nfarm2: " + coffee2.farm);
        Log.i(TAG, "Scope onCreate: \ncoffeeType1: " + coffee.coffeeType + "\ncoffeeType2: " + coffee2.coffeeType);

    }
}