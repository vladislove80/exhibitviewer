package com.techtask.exhibitviewer.di

import android.app.Application
import android.content.Context
import com.techtask.exhibitviewer.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun context(app: Application): Context {
            return app.applicationContext
        }
    }
}