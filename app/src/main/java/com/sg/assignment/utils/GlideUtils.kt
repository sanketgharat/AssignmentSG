package com.sg.assignment.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sg.assignment.R

object GlideUtils {

    fun setImage(context: Context, url: String, imageView: ImageView){
        Glide.with(context).load(url)
            .error(R.mipmap.ic_launcher_round)
            //.placeholder(R.mipmap.ic_launcher_round)
            .into(imageView)
    }
}