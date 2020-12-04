package com.example.mvvmstarterproject.di.modules

import com.example.mvvmstarterproject.di.modules.fragment.modules.MainActivityFragmentsProviders
import com.example.mvvmstarterproject.test.MainActivity
import com.example.mvvmstarterproject.ui.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModules {
    @ContributesAndroidInjector(modules = [MainActivityFragmentsProviders::class])
    abstract fun contributeHomeActivity(): HomeActivity
}