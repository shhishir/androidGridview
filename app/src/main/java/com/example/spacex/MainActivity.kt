package com.example.spacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex.adapter.RecycleViewAdapter
import com.example.spacex.datas.SpaceXDataItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.spacexdata.com/v5/"

class MainActivity : AppCompatActivity() {
    lateinit var spaceItemAdapter: RecycleViewAdapter
    lateinit var itemLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spaceRecycleView.setHasFixedSize(true)
        itemLayoutManager = GridLayoutManager(applicationContext, 3,LinearLayoutManager.VERTICAL, false)
        spaceRecycleView.layoutManager = itemLayoutManager

        getSpaceXData()
    }

    private fun getSpaceXData() {
        val rf = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val rfData = rf.getData()

        rfData.enqueue(object : Callback<List<SpaceXDataItem>?> {
            override fun onResponse(call: Call<List<SpaceXDataItem>?>,
                                    response: Response<List<SpaceXDataItem>?>) {
                val resBody = response.body()!!

                spaceItemAdapter = RecycleViewAdapter(baseContext, resBody)
                spaceItemAdapter.notifyDataSetChanged()
                spaceRecycleView.adapter = spaceItemAdapter

            }

            override fun onFailure(call: Call<List<SpaceXDataItem>?>, t: Throwable) {
               d("MainActivity","onFailure" + t.message )
            }
        })
    }
}