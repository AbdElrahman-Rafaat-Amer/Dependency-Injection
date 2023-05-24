package com.example.hilttraining.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

/*Here will pass all arguments that you may pass to the fragment
* look like factory for viewModel*/

class FragmentsFactory @Inject constructor(private val someString: String) : FragmentFactory() {

    //This function is responsible for which fragment will be created
    //Create a new instance of a Fragment with the given class name.
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when (className) {
            NamesFragment::class.java.name -> {
                NamesFragment(someString)
            }
            else -> super.instantiate(classLoader, className)
        }
    }
}