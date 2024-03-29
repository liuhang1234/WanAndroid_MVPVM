package com.lh.wanandroid.biz.main

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.lh.wanandroid.adapter.MainDataAdapter
import com.lh.wanandroid.base.BaseViewModel
import com.lh.wanandroid.data.Datas
import com.lh.wanandroid.data.HomeListData
import com.lh.wanandroid.http.HttpResponseSubscriber
import com.lh.wanandroid.http.HttpThrowable
import com.lh.wanandroid.http.RetrofitUtils
import com.lh.wanandroid.http.TransformUtils
import java.util.*

class MainViewModel:BaseViewModel() {

    val articleDetail by lazy { MutableLiveData<TextModel>()  }
    val datas by lazy { MutableLiveData<List<Datas>>() }
    var mAdapter : MainDataAdapter? = null


    fun getList(loadMore: Boolean) {
        Log.d("liuhang","getList")
        RetrofitUtils.createService().getHomeList(1)
            .compose(TransformUtils.defaultSchedulers())
            .subscribe(object : HttpResponseSubscriber<HomeListData>() {
                override fun onSuccess(result: HomeListData) {
                    var list = listOf(result.datas)
                    datas.value=result.datas
                    val text = TextModel(result.toString())
//                    articleDetail.value=text
                    articleDetail.value=text

                }

                override fun onHttpError(e: HttpThrowable) {
                    Log.d("liuhang onHttpError",e.toString())


                }

            })

    }

    fun changeText(){
        Log.d("liuhang","changeText")
        val text = TextModel("随机数字：")
        articleDetail.value=text
    }
}