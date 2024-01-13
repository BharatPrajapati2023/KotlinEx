package com.test.kotlinex

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DrawerActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Drawer Example")
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navi_view)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.home -> Toast.makeText(applicationContext, "Click Home", Toast.LENGTH_SHORT)
                    .show()

                R.id.message -> Toast.makeText(
                    applicationContext,
                    "Click Message",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.settings -> Toast.makeText(
                    applicationContext,
                    "Click Settings",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.user_profile -> Toast.makeText(
                    applicationContext,
                    "Click Profile",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.acc_settings -> Toast.makeText(
                    applicationContext,
                    "Click account Settings",
                    Toast.LENGTH_SHORT
                ).show()


            }
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}