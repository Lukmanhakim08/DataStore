package com.example.datastore.DataStorePrefenches.Latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datastore.DataStorePrefenches.UweManager
import com.example.datastore.R
import kotlinx.android.synthetic.main.activity_data_store_preferens.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    lateinit var dataRgister : DataRegister

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dataRgister = DataRegister(this)

        btn_register.setOnClickListener {
            val username = edt_username.text.toString()
            val password = edt_password.text.toString()

            GlobalScope.launch {
                dataRgister.register(username, password)
            }
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}