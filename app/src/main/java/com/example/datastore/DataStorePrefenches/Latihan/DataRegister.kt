package com.example.datastore.DataStorePrefenches.Latihan

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataRegister(context: Context) {
    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "register")
    private val logindataStore : DataStore<Preferences> = context.createDataStore(name = "login")

    companion object{
        val USERNAMA = preferencesKey<String>("USERNAMA")
        val PASSWORD = preferencesKey<String>("PASSWORD")
        val BOOLEAN  = preferencesKey<Boolean>("USER_BOLOLEAN")

    }

    suspend fun register(usernama: String, password:String){
        dataStore.edit {
            it[USERNAMA] = usernama
            it[PASSWORD] = password
        }
    }

    suspend fun authlogin(boolean: Boolean){
        logindataStore.edit {
            it[BOOLEAN] = boolean
        }
    }

    val Username : Flow<String> = dataStore.data.map {
        it[USERNAMA] ?: ""
    }

    val Password : Flow<String> = dataStore.data.map {
        it[PASSWORD] ?:""
    }

    val boolean: Flow<Boolean> = logindataStore.data.map {
        it[BOOLEAN] ?: false
    }

    suspend fun logOut(){
        dataStore.edit {
            it.clear()
        }
    }
}