package com.lh.wanandroid.biz.main

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lh.wanandroid.base.BaseFragment
import com.lh.wanandroid.base.BasePresenter
import com.lh.wanandroid.base.IView
import com.lh.wanandroid.data.Datas
import com.lh.wanandroid.data.HomeListData
import com.lh.wanandroid.databinding.FragmentMainBinding
import com.lh.wanandroid.http.HttpResponseSubscriber
import com.lh.wanandroid.http.HttpThrowable
import com.lh.wanandroid.http.RetrofitUtils
import com.lh.wanandroid.http.TransformUtils
import retrofit2.Retrofit

class MainPresenter(mContext: BaseFragment<*>, mView: MainContract.View) :


    BasePresenter<BaseFragment<*>,MainContract.View>(mContext, mView),MainContract.Presenter {
    lateinit var dataBinding: ViewDataBinding;
    val mMainModel by lazy { viewModelProvider(MainViewModel::class.java) }


    override fun getHomeList(loadMore: Boolean) {
        if (dataBinding is FragmentMainBinding) {
            (dataBinding as FragmentMainBinding).data =mMainModel
        }
        mMainModel.getList(loadMore)

    }

    /**
     * 点击按钮
     */
    override fun clickChange() {
        val text = TextModel("随机数字：11111111")
        mMainModel.articleDetail.value=text
    }


}