package com.sg.assignment.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MainData {

    companion object{
        const val TYPE_BANNER_IMAGE = "banner_image"
        const val TYPE_LIST = "list"
        const val TYPE_GRID = "grid"
    }

    @SerializedName("id")
    @Expose
    var id : Int = 0

    @SerializedName("type")
    @Expose
    var type : String = ""

    @SerializedName("columns")
    @Expose
    var columns : Int = 0

    @SerializedName("image_url")
    @Expose
    var imageUrl : String = ""

    @SerializedName("data")
    @Expose
    var dataList : List<Product> = emptyList()

}