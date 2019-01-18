package com.techtask.exhibitviewer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.techtask.exhibitviewer.R
import com.techtask.exhibitviewer.data.ActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerAdapter()
        observeViewModel()
    }

    private fun initRecyclerAdapter() {
        itemsList.adapter = ExhAdapter()
    }

    private fun observeViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ActivityViewModel::class.java)
        viewModel.getExhibitList().observe(this, Observer {
            if (!it.isNullOrEmpty()) (itemsList.adapter as ExhAdapter).addNewItems(it)
        })
    }
}

