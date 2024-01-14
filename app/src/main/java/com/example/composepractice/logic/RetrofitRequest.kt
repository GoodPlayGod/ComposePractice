package com.example.composepractice.logic

import android.util.Log
import com.example.composepractice.API_KEY
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface APIService {
    // ...

    @GET("/api/v1/employees")
    suspend fun getEmployees(): Response<ResponseBody>

    // ...
}

fun getMethod(name: String) {

    val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY&" +
            "q=$name" +
            "&aqi=no"
    // Create Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .build()

    // Create Service
    val service = retrofit.create(APIService::class.java)

    CoroutineScope(Dispatchers.IO).launch {
        /*
         * For @Query: You need to replace the following line with val response = service.getEmployees(2)
         * For @Path: You need to replace the following line with val response = service.getEmployee(53)
         */

        // Do the GET request and get response
        val response = service.getEmployees()

        withContext(Dispatchers.Main) {
            if (response.isSuccessful) {

                // Convert raw JSON to pretty JSON using GSON library
                val gson = GsonBuilder().setPrettyPrinting().create()
                val prettyJson = gson.toJson(
                    JsonParser.parseString(
                        response.body()
                            ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                    )
                )

                Log.d("Pretty Printed JSON :", prettyJson)

            } else {

                Log.e("RETROFIT_ERROR", response.code().toString())

            }
        }
    }
}