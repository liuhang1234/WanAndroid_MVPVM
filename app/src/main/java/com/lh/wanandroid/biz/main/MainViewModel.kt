package com.lh.wanandroid.biz.main

import androidx.databinding.ObservableField
import com.lh.wanandroid.base.BaseViewModel
import com.lh.wanandroid.data.HomeListData
import com.lh.wanandroid.http.HttpResponseSubscriber
import com.lh.wanandroid.http.HttpThrowable
import com.lh.wanandroid.http.RetrofitUtils
import com.lh.wanandroid.http.TransformUtils

class MainViewModel:BaseViewModel() {

    var articleDetail = ObservableField<String>()



    fun getList(loadMore: Boolean) {
        RetrofitUtils.createService().getHomeList(1)
            .compose(TransformUtils.defaultSchedulers())
            .subscribe(object : HttpResponseSubscriber<HomeListData>() {
                override fun onSuccess(result: HomeListData) {
                    articleDetail.set(result.toString())

                }

                override fun onHttpError(e: HttpThrowable) {
                    articleDetail.set(e.toString())

                }

            })

    }

    fun changeText(){

        articleDetail.set(System.currentTimeMillis().toString())
    }
}