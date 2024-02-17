package com.test.kotlinex

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.kotlinex.RecyclerView.OneModelItem
import com.test.kotlinex.RecyclerView.RecyclerOneAdapter
import com.test.kotlinex.Util.ApiClient
import com.test.kotlinex.Util.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerExActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private var dataOneList: List<OneModelItem> = mutableListOf()

    private lateinit var recyclerView: RecyclerView
    private lateinit var recOneAdapter: RecyclerOneAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_ex)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Recycler View Example")
        toolbar.setNavigationOnClickListener(View.OnClickListener { finish() })


        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        getApiData()
    }

    private fun getApiData() {
        val service = ApiClient.client?.create(ApiInterface::class.java)
        service?.getDataOne()?.enqueue(object : Callback<List<OneModelItem>?> {

            override fun onResponse(
                call: Call<List<OneModelItem>?>, response: Response<List<OneModelItem>?>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    dataOneList=result!!
                    recOneAdapter = RecyclerOneAdapter(applicationContext, dataOneList)
                    recyclerView.adapter = recOneAdapter
                    recOneAdapter.notifyDataSetChanged()


                }
            }

            override fun onFailure(call: Call<List<OneModelItem>?>, t: Throwable) {
                Toast.makeText(applicationContext, "Something went Wront", Toast.LENGTH_SHORT)
                    .show()
            }
        })


        /* service?.getDataOne()?.enqueue(object : Callback<OneModelItem> {
                override fun onResponse(call: Call<OneModelItem>, response: Response<OneModelItem>) {

                    if (response.isSuccessful) {
                        val result = response.body()
                        Log.wtf("print log=>", Gson().toJson(result))

                        val ite = OneModelItem(
                            result?.body,
                            result?.id,
                            result?.title,
                            result?.userId
                        )
                        dataOneList.add(ite)

                        recOneAdapter = RecyclerOneAdapter(applicationContext, dataOneList)
                        recyclerView.adapter = recOneAdapter
                    }


                    *//* val result = response.body()
                 val ite = DataOneItem(
                     result?.body,
                     result?.id,
                     result?.title,
                     result?.userId
                 )
                 dataOneList.add(ite)
                 recOneAdapter = RecyclerOneAdapter(applicationContext, dataOneList)
                 recyclerView.adapter = recOneAdapter*//*


            }

            override fun onFailure(call: Call<OneModelItem>, t: Throwable) {
                Toast.makeText(applicationContext, "Something went Wront", Toast.LENGTH_SHORT)
                    .show()
            }
        })*/
    }
}