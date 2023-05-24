package com.example.hilttraining.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hilttraining.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/*Once Hilt is set up in your Application class and an application-level component is available,
 Hilt can provide dependencies to other Android classes that have the @AndroidEntryPoint annotation
If you annotate an Android class with @AndroidEntryPoint, then you also must annotate Android classes that depend on it.
 For example, if you annotate a fragment, then you must also annotate any activities where you use that fragment.*/

/*@AndroidEntryPoint generates an individual Hilt component for each Android class in your project.
 These components can receive dependencies from their respective parent classes as described in Component hierarchy.
To obtain dependencies from a component, use the @Inject annotation to perform field injection:*/

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Fields injected by Hilt cannot be private. Attempting to inject a private field with Hilt results in a compilation error.
    // Classes that Hilt injects can have other base classes that also use injection.
    // Those classes don't need the @AndroidEntryPoint annotation if they're abstract.

    /* @Inject
     lateinit var fragmentFactory: FragmentsFactory*/
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //   showFragment()
    }

/*    private fun showFragment() {
        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_root, NamesFragment::class.java, null)
            .commit()
    }*/

}