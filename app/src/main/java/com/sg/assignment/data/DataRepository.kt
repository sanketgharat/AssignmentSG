package com.sg.assignment.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sg.assignment.data.models.MainData
import com.sg.assignment.utils.Constants
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.io.IOException

class DataRepository(private val context: Context) {


    suspend fun fetchData(): List<MainData>? {
        var json: String? = null
        json = withContext(IO) {
            try {
                val inputStream = context.assets.open(Constants.JSON_FILE_NAME)
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                buffer.toString(charset("UTF-8"))
            } catch (ex: IOException) {
                ex.printStackTrace()
                ""
            }
        }

        var mainDataList: List<MainData>? = null

        if (!json.isNullOrEmpty()) {
            val gson = Gson()
            val type = object : TypeToken<List<MainData>>() {}.type
            mainDataList = gson.fromJson<List<MainData>>(json, type)

        }

        return mainDataList

    }


}