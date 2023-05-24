package com.example.hilttraining.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.hilttraining.databinding.ActivityMain2Binding
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    /*  @Inject //Filed Injection
      lateinit var book: Book*/

    @Inject //Filed Injection
    lateinit var test: Test
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        test.printSomeThing1()
        test.printSomeThing2()
        /* book.printBookPages()
         book.printPageNumber()
         book.printSomething()*/
    }
}

/*
class Book @Inject constructor(
    private val page: BookPage //Constructor injection
    , private val testProblemsImpl: TestProblemsImpl
) {
    fun printBookPages() {
        println("Book contains 12 pages")
    }

    fun printPageNumber() {
        page.printPageNumber()
    }

    fun printSomething() {
        testProblemsImpl.printSomething()
    }
}

class BookPage @Inject constructor() {
    fun printPageNumber() {
        println("PageNumber is number 12")
    }
}*/

class Test @Inject constructor(
    @Impl1 private val testProblemsImpl1: TestProblems,
    @Impl2 private val testProblemsImpl2: TestProblems,
    //  private val gson: Gson
) {
    //ProvideModule
    /*   fun printSomeThing() {
           testProblemsImpl1.printSomething()
       }*/

    fun printSomeThing1() {
        testProblemsImpl1.printSomething()
    }

    fun printSomeThing2() {
        testProblemsImpl2.printSomething()
    }
}

class TestProblemsImpl @Inject constructor(private val string: String) : TestProblems {
    override fun printSomething() {
        println("You are inside TestProblemsImpl string $string")
    }
}

class TestProblemsImpl1 @Inject constructor() : TestProblems {
    override fun printSomething() {
        println("You are inside TestProblemsImpl1")
    }
}

class TestProblemsImpl2 @Inject constructor() : TestProblems {
    override fun printSomething() {
        println("You are inside TestProblemsImpl2")
    }
}

interface TestProblems {
    fun printSomething()
}

/*@InstallIn(ActivityComponent::class)
@Module
abstract class BindModule {
    @ActivityScoped
    @Binds
    abstract fun bindSomeThing(someImpl: TestProblemsImpl): TestProblems

    @ActivityScoped
    @Binds
    abstract fun bindGson(gson: Gson): Gson
}*/

/*@InstallIn(SingletonComponent::class)
@Module
class ProvideModule {

    @Singleton
    @Provides
    fun provideString(): String {
        return "provideString"
    }

    @Singleton
    @Provides
    fun provideSomeThing(someString : String): TestProblems {
        return TestProblemsImpl(someString)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}*/

@InstallIn(SingletonComponent::class)
@Module
class ProvideModule1 {

    @Impl1
    @Singleton
    @Provides
    fun provideSomeThing1(): TestProblems {
        return TestProblemsImpl1()
    }

    @Impl2
    @Singleton
    @Provides
    fun provideSomeThing2(): TestProblems {
        return TestProblemsImpl2()
    }
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2