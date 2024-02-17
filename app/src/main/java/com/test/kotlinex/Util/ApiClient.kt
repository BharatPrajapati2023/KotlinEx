package com.test.kotlinex.Util

import android.annotation.SuppressLint
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
object ApiClient {
    // Retrofit instance
    private var retrofit: Retrofit? = null

    /**
     * Getter for the Retrofit instance.
     */

    val client: Retrofit?
        get() {
            // Create the Retrofit instance if it is null
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(API.BASE_URL)
                    .client(unsafeOkHttpClient) // Use the custom OkHttpClient with SSL/TLS modifications
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

    // Custom OkHttpClient with SSL/TLS modifications
    private val unsafeOkHttpClient: OkHttpClient
        get() = try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                @SuppressLint("TrustAllX509TrustManager")
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                @SuppressLint("TrustAllX509TrustManager")
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            })

            // Create a new SSL context with the default trust manager
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, trustAllCerts, null)

            // Create a new SSL socket factory with the updated SSL context
            val sslSocketFactory = sslContext.socketFactory

            // Create a new HostnameVerifier that allows all hostnames
            val hostnameVerifier =
                HostnameVerifier { hostname: String?, session: SSLSession? -> true }

            val interceptor = OkHttpProfilerInterceptor()

            // Create OkHttpClient with SSL/TLS modifications
            val builder = OkHttpClient.Builder()
                .addInterceptor(interceptor) // Add OkHttpProfilerInterceptor in debug mode
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                .hostnameVerifier(hostnameVerifier)

            builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
}