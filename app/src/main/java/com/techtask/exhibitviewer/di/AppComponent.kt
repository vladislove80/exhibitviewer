package com.techtask.exhibitviewer.di

import android.app.Application
import com.techtask.exhibitviewer.ExhApp
import com.techtask.fileexhibitsloader.Api
import com.techtask.fileexhibitsloader.FileExhibitsLoader
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, FileExhibitsLoader::class, Api::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<ExhApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun provideLoader(loader: FileExhibitsLoader): AppComponent.Builder

        fun build(): AppComponent
    }

    override fun inject(app: ExhApp)
}