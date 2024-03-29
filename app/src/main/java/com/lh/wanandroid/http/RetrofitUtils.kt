package com.lh.wanandroid.http

import com.lh.wanandroid.connfig.EnvControl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils private constructor() {
    companion object {
        @Volatile
        private var retrofit: Retrofit? = null

        fun createService():ApiService {
            if (retrofit == null) {
                synchronized(RetrofitUtils::class) {
                    if (retrofit == null) {
                        retrofit = Retrofit.Builder()
                            .baseUrl(EnvControl.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(OkHttpUtil.defaultOkHttpClient())
                            .build()
                    }
                }
            }
            return retrofit!!.create(ApiService::class.java)
        }

    }
}