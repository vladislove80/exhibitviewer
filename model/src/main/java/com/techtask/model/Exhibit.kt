package com.techtask.model

import com.google.gson.annotations.SerializedName

data class Exhibit(@SerializedName("images") val title: String = "", @SerializedName("title") val images: List<Exhibit>)