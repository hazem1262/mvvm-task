package com.example.mvvmstarterproject.di.modules.fragment.modules

import com.example.mvvmstarterproject.ui.sendMessage.SendMessageFragment
import com.example.mvvmstarterproject.ui.signup.SignUpFragment
import com.example.mvvmstarterproject.ui.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsProviders {
    @ContributesAndroidInjector
    abstract fun contributeWelcomeFragment(): WelcomeFragment

    @ContributesAndroidInjector
    abstract fun contributeSignUpFragment(): SignUpFragment

    @ContributesAndroidInjector
    abstract fun contributeSendMessageFragment(): SendMessageFragment

}