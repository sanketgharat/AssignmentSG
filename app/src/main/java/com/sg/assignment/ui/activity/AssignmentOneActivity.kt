package com.sg.assignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.sg.assignment.R
import com.sg.assignment.databinding.ActivityAssignmentOneBinding
import com.sg.assignment.databinding.ActivityMainBinding

class AssignmentOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAssignmentOneBinding

    /*sample images
    * https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg
    * https://sample-videos.com/img/Sample-jpg-image-200kb.jpg
    * https://www.learningcontainer.com/wp-content/uploads/2020/09/Sample-Image-File-for-Testing.png
    * https://sample-videos.com/img/Sample-jpg-image-1mb.jpg
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLoad.setOnClickListener {
            loadUrl()
        }
    }

    private fun loadUrl(){
        val url =  binding.etUrl.text.toString()
        //val url = "https://sample-videos.com/img/Sample-jpg-image-1mb.jpg"
        if(url.isBlank()){
            Toast.makeText(this, "please enter url", Toast.LENGTH_SHORT).show()
            return
        }

        setImage(url, binding.imageView)
    }



    private fun setImage(url: String, imageView: ImageView){
        Glide.with(this).load(url)
            .error(R.mipmap.ic_launcher_round)
            //.placeholder(R.mipmap.ic_launcher_round)
            .into(imageView)
    }
}