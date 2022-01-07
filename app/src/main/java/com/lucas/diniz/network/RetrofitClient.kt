package com.lucas.diniz.network

import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object RetrofitClient : AppCompatActivity() {

    private const val BASE_URL = "https://revs.newrastreamentoonline.com.br/gateway/"

    fun <T> getApi(service: Class<T>) =
        buildRetrofit(getUnsafeOkHttpClient())
            .create(service)

    private fun buildRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()

    private fun getUnsafeOkHttpClient(): OkHttpClient {
        try {

            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {

                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate?> {
                    return arrayOfNulls(0)
                }

            })

            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(
                null, trustAllCerts,
                java.security.SecureRandom()
            )

            val sslSocketFactory = sslContext
                .getSocketFactory()

            var okHttpClient = OkHttpClient()
            okHttpClient = okHttpClient.newBuilder()
                .sslSocketFactory(sslSocketFactory)
                .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                .build()

            return okHttpClient

        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}
