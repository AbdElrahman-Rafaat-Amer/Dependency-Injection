package com.example.hilttraining.di

import android.util.Log
import com.example.hilttraining.adapter.OnNameClickListener
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@InstallIn(FragmentComponent::class)
@Module
object AdapterModule {

    @FragmentScoped
    @Provides
    fun provideOnNameClickedInstance() : OnNameClickListener{
        return OnNameClickImpl()
    }
}

class OnNameClickImpl @Inject constructor(): OnNameClickListener {
    override fun onItemClicked(name: String) {
        Log.i("TestClick", "AdapterModule onItemClicked: name ----> $name")
    }
}
