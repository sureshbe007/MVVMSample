package com.example.mvvmsample.di.builder;

import com.example.mvvmsample.ui.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

}
