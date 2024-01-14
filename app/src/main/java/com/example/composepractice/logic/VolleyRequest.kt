package com.example.composepractice

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.snapshots.SnapshotStateMap
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

const val API_KEY = "2a590caf324a4ce5912130317231112"

fun getData(name: String, context: Context, mState: SnapshotStateMap<String, String>) {
    val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY&" +
            "q=$name" +
            "&aqi=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val obj = JSONObject(response)
            val indicators = obj.getJSONObject("current")
            mState["Температура"] = indicators.getString("temp_c")
            mState["Облачность"] = indicators.getString("cloud")
            mState["Скорость ветра"] = indicators.getString("wind_mph")
            mState["Влажноссть"] = indicators.getString("humidity")
            mState["Уровень УФ"] = indicators.getString("uv")
            Log.d("MyLog", "Response: ${indicators.getString("temp_c")}")
        },
        {
            Log.d("MyLog", "Volley error: $it")
        }
    )
    queue.add(stringRequest)
}