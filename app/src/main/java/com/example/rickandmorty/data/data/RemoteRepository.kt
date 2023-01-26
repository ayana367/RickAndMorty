package com.example.rickandmorty.data.data

import android.hardware.camera2.CaptureFailure
import com.example.rickandmorty.data.model.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {
    fun getCharacters(page: Int, returnOnSuccess: (Characters) -> Unit, returnOnFailure: (String) -> Unit) {
     RetrofitClient.api.getCharacters(page).enqueue(object : Callback<Characters>{
         override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
             response.isSuccessful
             returnOnSuccess(response.body()!!)
         }

         override fun onFailure(call: Call<Characters>, t: Throwable) {
            returnOnFailure(t.message?:"Unknown Error")
         }

     })
    }
}