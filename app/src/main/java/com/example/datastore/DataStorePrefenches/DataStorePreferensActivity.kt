package com.example.datastore.DataStorePrefenches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.datastore.R
import kotlinx.android.synthetic.main.activity_data_store_preferens.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataStorePreferensActivity : AppCompatActivity() {
    lateinit var uweManager : UweManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_store_preferens)

        uweManager = UweManager(this)

        btn_save.setOnClickListener {
            val nama = edt_nama.text.toString()
            val umur = edt_umur.text.toString().toInt()

            GlobalScope.launch {
                uweManager.saveData(nama, umur)
            }
        }

        uweManager.userNama.asLiveData().observe(this,{
            tv_nama.text = it.toString()
        })

        uweManager.userUmur.asLiveData().observe(this,{
            tv_umur.text = it.toString()
        })

        btn_clear.setOnClickListener {
            GlobalScope.launch {
                uweManager.hapusData()
            }
        }
    }
}