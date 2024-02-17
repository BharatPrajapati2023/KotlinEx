package com.test.kotlinex.Util

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.test.kotlinex.R
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import java.util.concurrent.ExecutorService

class ApplicationClass : Application() {
    companion object {
        const val TAG = "ApplicationClass"
        lateinit var instance: ApplicationClass
        private var service: ExecutorService? = null

    }
    override fun onCreate() {
        super.onCreate()
        instance = this

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("Neuton-Regular.ttf")
                            .setFontAttrId(androidx.core.R.attr.font)
                            .build()
                    )
                )
                .build()
        )

    }
    fun toast(message: String?) {
        Toast.makeText(this, message ?: "Something went wrong!", Toast.LENGTH_SHORT).show()

    }

    fun showSnackBar(view: View, message: String?) {
        Snackbar.make(view, message!!, Snackbar.LENGTH_SHORT).show()
    }

    val isNetworkAvailable: Boolean
        get() {
            try {
                val connectivityManager =
                    this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                return (activeNetworkInfo != null) && activeNetworkInfo.isConnected
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }


    fun showSnackBar(view: View, msg: String, retry: () -> Unit) {
        val snack = Snackbar.make(view, msg, Snackbar.LENGTH_INDEFINITE)
        snack.setAction("Retry") {
            retry()
        }
        snack.show()
    }

    private fun showBottomDialog(isConnected: Boolean, context: Context) {

        val dialog = BottomSheetDialog(context, R.style.BottomSheetDialog)
        dialog.setContentView(R.layout.row_no_internet_bottom_layout)

        val imagePreview = dialog.findViewById<AppCompatImageView>(R.id.wifi_image)
        val closeDialog = dialog.findViewById<AppCompatTextView>(R.id.dismiss)
        val connectionText = dialog.findViewById<AppCompatTextView>(R.id.connection_text)

        closeDialog?.setOnClickListener {  //handle click event
            // Toast.makeText(this, "Perform edit operation", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        var dialogShow: Boolean? = false

        dialog.show()
        if (isConnected) {

        }else {

        }
    }

}