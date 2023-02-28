package com.example.car_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.os.postDelayed

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        Handler().postDelayed({
            val moveIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }, 3000)


    }
}