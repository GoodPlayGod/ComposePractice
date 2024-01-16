package com.example.composepractice.logic

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateMap
import com.example.composepractice.ui.API_KEY
import com.example.composepractice.ui.city
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
import org.json.JSONObject

interface APIService {
    // ...
    @GET("?key=$API_KEY&q=$city&aqi=no")
    suspend fun getWeather(): Response<ResponseBody>

    // ...
}

fun getMethod(city: String, mState: SnapshotStateMap<String, String>) {
    val url = "https://api.weatherapi.com/v1/current.json"
    // Create Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .build()

    // Create Service
    val service = retrofit.create(APIService::class.java)

    CoroutineScope(Dispatchers.IO).launch {

        // Do the GET request and get response
        val response = service.getWeather()

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
                val obj = JSONObject(prettyJson)
                val indicators = obj.getJSONObject("current")
                mState["Температура"] = indicators.getString("temp_c")
                mState["Облачность"] = indicators.getString("cloud")
                mState["Скорость ветра"] = indicators.getString("wind_mph")
                mState["Влажноссть"] = indicators.getString("humidity")
                mState["Уровень УФ"] = indicators.getString("uv")
                Log.d("Pretty Printed JSON :", prettyJson)

            } else {

                Log.e("RETROFIT_ERROR", response.code().toString())

            }
        }
    }
}