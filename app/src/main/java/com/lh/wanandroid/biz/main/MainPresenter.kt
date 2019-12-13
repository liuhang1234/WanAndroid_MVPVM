package com.lh.wanandroid.biz.main

import androidx.lifecycle.ViewModelProvider
import com.lh.wanandroid.base.BaseFragment
import com.lh.wanandroid.base.BasePresenter
import com.lh.wanandroid.base.IView
import com.lh.wanandroid.data.Datas
import com.lh.wanandroid.data.HomeListData
import com.lh.wanandroid.http.HttpResponseSubscriber
import com.lh.wanandroid.http.HttpThrowable
import com.lh.wanandroid.http.RetrofitUtils
import com.lh.wanandroid.http.TransformUtils
import retrofit2.Retrofit

class MainPresenter(mContext: BaseFragment<*>, mView: MainContract.View) :


    BasePresenter<BaseFragment<*>,MainContract.View>(mContext, mView),MainContract.Presenter {

    val mMainModel by lazy { viewModelProvider(MainViewModel::class.java) }


    override fun getHomeList(loadMore: Boolean) {
        mMainModel.getList(loadMore)
    }

    /**
     * 点击按钮
     */
    override fun clickChange() {
        mMainModel.changeText()
    }


}