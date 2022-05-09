package com.example.datastore.DataStorePrefenches.Latihan

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.asLiveData
import com.example.datastore.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    lateinit var dataRegister: DataRegister

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        dataRegister = DataRegister(this)

        dataRegister.Username.asLiveData().observe(this, {
            tv_username.text = "Hello, " + it.toString()
        })

        btn_logout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah anda yakin ingin logot")
                .setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->
                    GlobalScope.launch {
                        DataRegister(this@HomeActivity).logOut()
                        startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
                        finish()
                    }
                }
                .setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->

                }
                .show()
        }
    }
}