package com.test.kotlinex

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ListViewActivity : AppCompatActivity() {
    val language = arrayOf<String>(
        "C",
        "C++",
        "JAVA",
        "KOTLIN",
        "JSP",
        ".NET",
        "JAVA SCRIPT",
        "PHP",
        "AJAX",
        "PERL",
        "PYTHEN"
    )
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("List View Example")

        listView = findViewById(R.id.single_list_item)

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, language)
        listView.adapter = arrayAdapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val seletedItem = parent.getItemAtPosition(position) as String
                val itemPosition = parent.getItemIdAtPosition(position)

                Toast.makeText(
                    applicationContext,
                    "Clicked Items $seletedItem its position $itemPosition",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }
}