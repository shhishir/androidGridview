package com.example.spacex

import com.example.spacex.datas.SpaceXDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(value = "launches")
    fun getData(): Call<List<SpaceXDataItem>>
}