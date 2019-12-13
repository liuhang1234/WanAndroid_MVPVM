package com.lh.wanandroid.biz.main

import com.lh.wanandroid.base.IPresenter
import com.lh.wanandroid.base.IView
import com.lh.wanandroid.data.Datas

interface MainContract {
    interface View : IView{
        fun showData(datas: List<Datas>)
    }
    interface Presenter:IPresenter{
        fun getHomeList(loadMore:Boolean)
    }
}