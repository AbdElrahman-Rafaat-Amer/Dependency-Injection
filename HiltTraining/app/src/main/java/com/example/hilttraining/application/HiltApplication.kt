package com.example.hilttraining.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//First step to make ApplicationClass annotated with @@HiltAndroidApp
//@HiltAndroidApp triggers Hilt's code generation,
// including a base class for your application that serves as the application-level dependency container.


@HiltAndroidApp
class HiltApplication : Application() {
}