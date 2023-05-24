package com.example.movies.di

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class MainNavHostFragment : NavHostFragment() {

//    @OptIn(ExperimentalCoroutinesApi::class)
    @Inject
    lateinit var fragmentFactory: FragmentsFactory

  //  @OptIn(ExperimentalCoroutinesApi::class)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = fragmentFactory
    }
}