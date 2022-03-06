package com.sg.assignment.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName("product_id")
    @Expose
    var productId : Int = 0

    @SerializedName("product_name")
    @Expose
    var productName : String = ""

    @SerializedName("product_description")
    @Expose
    var productDescription : String = ""

    @SerializedName("product_image")
    @Expose
    var productImage : String = ""

}