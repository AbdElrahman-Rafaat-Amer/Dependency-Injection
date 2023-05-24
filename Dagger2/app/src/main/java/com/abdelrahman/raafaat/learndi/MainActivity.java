package com.abdelrahman.raafaat.learndi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.abdelrahman.raafaat.learndi.model.Coffee;
import com.abdelrahman.raafaat.learndi.model.Farm;
import com.abdelrahman.raafaat.learndi.model.River;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Abdo-----------MainActivity";

    @Inject
    Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Manual injection
//        Farm farm = new Farm();
//        River river = new River();
//        Coffee coffee = new Coffee(farm, river);


        //Automate injection by dagger

        CoffeeComponent coffeeComponent = DaggerCoffeeComponent.create();
        coffeeComponent.inject(this);
//        String coffeeInfo = coffeeComponent.getCoffee().getCoffeeInfo();
        String coffeeInfo = coffee.getCoffeeInfo();
        Log.i(TAG, "onCreate:coffeeInfo " + coffeeInfo);
    }
}