package com.example.car_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.When

class MainActivity : AppCompatActivity() {

    private lateinit var rvCar: RecyclerView
    private val list = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCar = findViewById(R.id.rv_car)
        rvCar.setHasFixedSize(true)

        list.addAll(getCarData())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.list -> {
                rvCar.layoutManager = LinearLayoutManager(this)
            }
            R.id.Grid -> {
                rvCar.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getCarData() : ArrayList<Car>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataSpec = resources.getStringArray(R.array.Spesifikasi)
        val listCar = ArrayList<Car>()
        for (i in dataName.indices) {
            val car = Car(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataSpec[i])
            listCar.add(car)
        }
        return listCar

    }

    private fun showRecyclerList() {
        rvCar.layoutManager = LinearLayoutManager(this)
        val listCarAdapter = ListCarAdapter(list)
        rvCar.adapter = listCarAdapter
    }
}