package com.test.kotlinex

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class AlertDialogActivity : AppCompatActivity() {
    lateinit var alertDialog: AppCompatButton
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        alertDialog = findViewById(R.id.alert_dialog)

        alertDialog.setOnClickListener(View.OnClickListener { view ->

            showDialogs()
        })
    }

    private fun showDialogs() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Alert Dialog")
        dialog.setMessage("This is a Simple Dialog for clicking enter face")

        dialog.setPositiveButton("Yes") { dialoginteface, which ->
            Toast.makeText(applicationContext, "Yes Sure", Toast.LENGTH_SHORT).show()
        }
        dialog.setNegativeButton("No") { dialoginterface, which ->
            Toast.makeText(applicationContext, "No i am not Sure", Toast.LENGTH_SHORT).show()
        }
        dialog.setNeutralButton("Cancel") { dialoginterface, which ->
            Toast.makeText(applicationContext, "first confirm and take action", Toast.LENGTH_SHORT)
                .show()

        }

        val alert: AlertDialog = dialog.create()
        alert.setCancelable(false)
        alert.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                Toast.makeText(applicationContext, "Home Menu Selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.message->{
                Toast.makeText(applicationContext, "Message Menu Selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.settings->{
                Toast.makeText(applicationContext, "Settings Menu Selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.user_profile->{
                Toast.makeText(applicationContext, "User Profile Menu Selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.acc_settings->{
                Toast.makeText(applicationContext, "account Settings Menu Selected", Toast.LENGTH_SHORT).show()
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }
}