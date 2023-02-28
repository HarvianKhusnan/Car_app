package com.example.car_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    private val viewmodel: ViewModelData by viewModels()
    private val About:String="About"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        supportActionBar?.apply {
            title = About
        }

        val tvName: TextView = findViewById(R.id.Nama)
        val tvSpec: TextView = findViewById(R.id.Spesifikasi)
        val tvPrice: TextView = findViewById(R.id.harga)
        val photo: ImageView = findViewById(R.id.imageView)


        var intent = intent
        val name = intent.getStringExtra("names")
        val desc = intent.getStringExtra("descrip")
        val spek = intent.getStringExtra("speci")
        val pho = intent.getIntExtra("foto",0)


        tvName.text = name
        viewmodel.name.postValue(tvName.text.toString())
        tvSpec.text = spek
        tvPrice.text = desc
        photo.setImageResource(pho)

    }


}