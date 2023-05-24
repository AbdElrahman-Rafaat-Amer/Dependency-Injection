package com.example.notes

/*
you must user @AndroidEntryPoint for every view you want to use
if this view use Adapter for recyclerView
*/

/*
class AnalyticsAdapter @Inject constructor(
  private val service: AnalyticsService
) { ... }
The parameters of an annotated constructor of a class are the dependencies of that class. In the example,
AnalyticsAdapter has AnalyticsService as a dependency. Therefore, Hilt must also know how to provide instances of AnalyticsService.

Note:
At build time, Hilt generates Dagger components for Android classes. Then, Dagger walks through your code and performs the following steps:
    1- Builds and validates dependency graphs, ensuring that there are no unsatisfied dependencies and no dependency cycles.
    2- Generates the classes that it uses at runtime to create the actual objects and their dependencies.

*/
/*
--------------------------------------------------Scopes--------------------------------------------------
Android class	                            Generated component	                            Scope
Application	                                SingletonComponent		                         @Singleton
Activity		                            ActivityRetainedComponent	                     @ActivityRetainedScoped
ViewModel		                            ViewModelComponent		                         @ViewModelScoped
Activity		                            ActivityComponent	    	                     @ActivityScoped
Fragment		                            FragmentComponent	                             @FragmentScoped
View		                                ViewComponent		                             @ViewScoped
View annotated with @WithFragmentBindings	ViewWithFragmentComponent	                     @ViewScoped
Service	    	                            ServiceComponent		                         @ServiceScoped

Note: Scoping a binding to a component can be costly because the provided object stays in memory until that component is destroyed.
Minimize the use of scoped bindings in your application.
 It is appropriate to use component-scoped bindings
     -for bindings with an internal state that requires that same instance to be used within a certain scope,
     -for bindings that need synchronization,
     -for bindings that you have measured to be expensive to create.

Note: You can inject class with high level or equivalent scope to other class but you can not do the opposite it will generate compile time error
*/

/*
--------------------------------------------------Constructor Injection --------------------------------------------------
 Has two problems (This problems generate compile time error):
 1- When you want to Inject class you don't own it (When you inject class from third library like retrofit, Json or any other class)
 2- When you want to Inject Interface

 Solution:
 @Provides is easier and works always in all case but @Binds is the opposite
 */

