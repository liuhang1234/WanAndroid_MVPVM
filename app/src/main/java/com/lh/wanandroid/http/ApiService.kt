package com.lh.wanandroid.http

import com.lh.wanandroid.data.HomeListData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /**
     * 首页
     */
    @GET("article/list/{index}/json")
    fun getHomeList(@Path("index")index:Int ): Observable<BaseResponse<HomeListData>>
}