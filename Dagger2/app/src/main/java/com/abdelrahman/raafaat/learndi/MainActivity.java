package com.abdelrahman.raafaat.learndi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.abdelrahman.raafaat.learndi.model.Coffee;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Abdo-----------MainActivity";

    @Inject
    Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        CoffeeComponent coffeeComponent  = DaggerCoffeeComponent.create();
//        CoffeeComponent coffeeComponent  = DaggerCoffeeComponent.builder().coffeeTypeModule(new CoffeeTypeModule(18657480)).build();
        CoffeeComponent coffeeComponent  = DaggerCoffeeComponent.builder().setSugar(7).setMilk(102).buildCoffeeComponent();
        /**
        *This is an example how to provide an object of Coffee class without using Filed injection to Coffee class
         */
//         coffeeComponent.getCoffee().getCoffeeInfo();


        Log.i(TAG, "onCreate: ==============================================================================================");
        coffeeComponent.inject(this);
        coffee.getCoffeeInfo();

    }
}