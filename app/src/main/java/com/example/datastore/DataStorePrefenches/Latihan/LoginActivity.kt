package com.example.datastore.DataStorePrefenches.Latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.datastore.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var dataRegister : DataRegister

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dataRegister = DataRegister(this)

        btn_registersab.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_login.setOnClickListener {
            val username = it_username.text.toString()
            val password = it_password.text.toString()

            dataRegister.Username.asLiveData().observe(this){
                if (username == it){
                    dataRegister.Password.asLiveData().observe(this){ data ->
                        if (password == data){
                            GlobalScope.launch {
                                dataRegister.authlogin(true)
                            }
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "Password salah", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Username belum terdaftar", Toast.LENGTH_SHORT).show()
                }
            }
            }
    }
}