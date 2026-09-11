package com.example.compose1.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class TmdbAuthInterceptor(
    private val bearerToken: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .addHeader("accept", "application/json")

        if (bearerToken.isNotBlank()) {
            requestBuilder.addHeader("Authorization", "Bearer $bearerToken")
        }

        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}



