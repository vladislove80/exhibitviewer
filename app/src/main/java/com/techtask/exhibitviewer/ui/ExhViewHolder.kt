package com.techtask.exhibitviewer.ui

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techtask.model.Exhibit
import kotlinx.android.synthetic.main.exhebit_item.view.*

class ExhViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    val title = view.title
    private val horizontalImageList = view.llImageList

    fun bind(exhItem: Exhibit) {
        title.text = exhItem.title
        exhItem.images.forEachIndexed { index, _ ->
            ImageView(view.context).apply {
                this.scaleType = ImageView.ScaleType.CENTER_CROP
                this.layoutParams = LinearLayout.LayoutParams(500, 500)
                horizontalImageList.addView(this)
                Glide.with(context).load(index).into(this)
            }
        }
    }
}