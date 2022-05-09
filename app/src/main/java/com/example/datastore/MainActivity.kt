package com.example.datastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datastore.DataStorePrefenches.DataStorePreferensActivity
import com.example.datastore.DataStorePrefenches.Latihan.LatihanPrefeDataActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_datastore.setOnClickListener {
            startActivity(Intent(this,DataStorePreferensActivity::class.java))
        }

        btn_latihan.setOnClickListener {
            startActivity(Intent(this, LatihanPrefeDataActivity::class.java))
        }
    }
}