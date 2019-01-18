package com.techtask.exhibitviewer.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techtask.fileexhibitsloader.FileExhibitsLoader
import com.techtask.model.Exhibit
import javax.inject.Inject

class ActivityViewModel @Inject constructor(var loader: FileExhibitsLoader) : ViewModel() {
    private var list = MutableLiveData<List<Exhibit>>()

    fun getExhibitList(): MutableLiveData<List<Exhibit>> {
        list = loader.getExhibitList() as MutableLiveData<List<Exhibit>>
        return list
    }

    override fun onCleared() {
        super.onCleared()
        loader.onCleared()
    }
}