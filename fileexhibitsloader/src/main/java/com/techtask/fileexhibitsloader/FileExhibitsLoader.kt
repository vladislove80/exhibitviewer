package com.techtask.fileexhibitsloader

import com.techtask.model.Exhibit
import com.techtask.model.ExhibitsLoader
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Module(includes = [ApiService::class])
class FileExhibitsLoader : ExhibitsLoader {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var list: List<Exhibit>

    @Inject
    lateinit var apiService: ApiService

    @Provides
    @Singleton
    override fun getExhibitList(): List<Exhibit> {
        compositeDisposable.add(
            apiService.getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list = it }, { list = ArrayList() })
        )
        return list
    }

    @Provides
    @Singleton
    fun onCleared() {
        compositeDisposable.dispose()
    }
}