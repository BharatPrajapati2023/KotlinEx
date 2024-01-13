package com.test.kotlinex

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.test.kotlinex.databinding.ActivityMainBinding

public class MainActivity : AppCompatActivity() {
    lateinit var simpleButton: Button
    lateinit var drawerButton: Button
    lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        //simpleButton = findViewById(R.id.simple_button)
        binding.simpleButton.setOnClickListener(View.OnClickListener { view ->
            // Toast.makeText(applicationContext, "simple Toast calling", Toast.LENGTH_SHORT).show();

            intent = Intent(this, AlertDialogActivity::class.java)
            startActivity(intent)
        })
        binding.drawerButton.setOnClickListener(View.OnClickListener { view ->
            intent = Intent(this, DrawerActivity::class.java)
            startActivity(intent)

        })
        binding.listButton.setOnClickListener(View.OnClickListener { View ->
            intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        })

    }

    private fun implysitIntent() {
        intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.google.com/"))
        startActivity(intent)
    }
}