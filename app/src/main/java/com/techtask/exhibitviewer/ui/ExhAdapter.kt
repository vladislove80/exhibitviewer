package com.techtask.exhibitviewer.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techtask.exhibitviewer.R
import com.techtask.model.Exhibit

class ExhAdapter : RecyclerView.Adapter<ExhViewHolder>() {
    private val exhItems: MutableList<Exhibit> = mutableListOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ExhViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val view = layoutInflater.inflate(R.layout.exhebit_item, p0, false)
        return ExhViewHolder(view)
    }

    override fun getItemCount() = exhItems.size

    override fun onBindViewHolder(holder: ExhViewHolder, position: Int) = holder.bind(exhItems[position])

    fun addNewItems(newItems: List<Exhibit>) {
        val isAdded = exhItems.addAll(newItems)
        if (isAdded) notifyDataSetChanged()
    }
}