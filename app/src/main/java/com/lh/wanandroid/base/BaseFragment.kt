package com.lh.wanandroid.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.trello.rxlifecycle2.components.support.RxFragment

abstract class BaseFragment<VB : ViewDataBinding> : RxFragment() {



    protected var mActivity: BaseActivity? = null

    override fun onAttach(activity: Context) {
        super.onAttach(activity)
        if (activity is BaseActivity) {
            mActivity = activity
        }
    }




    //这个时候 view 才初始化完成 可以直接通过view的id 寻找控件
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view,savedInstanceState)
    }



    abstract fun initView(view : View, savedInstanceState: Bundle?)


}