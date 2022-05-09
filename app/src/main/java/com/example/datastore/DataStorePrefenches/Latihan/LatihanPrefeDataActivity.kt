package com.example.datastore.DataStorePrefenches.Latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.window.SplashScreen
import androidx.lifecycle.asLiveData
import com.example.datastore.DataStorePrefenches.UweManager
import com.example.datastore.MainActivity
import com.example.datastore.R

class LatihanPrefeDataActivity : AppCompatActivity() {
    lateinit var dataRegister : DataRegister
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_prefe_data)
        dataRegister = DataRegister(this)
        Handler().postDelayed({
            dataRegister.boolean.asLiveData().observe(this){
                if (it == true){
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }else{
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }, 3000)
    }
}