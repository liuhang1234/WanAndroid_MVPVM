package com.lh.wanandroid.biz.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.lh.wanandroid.R
import com.lh.wanandroid.adapter.MainDataAdapter
import com.lh.wanandroid.base.BaseFragment
import com.lh.wanandroid.data.Datas
import com.lh.wanandroid.databinding.FragmentMainBinding
import com.lh.wanandroid.databinding.ItemHomeListBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() ,MainContract.View{
    private val mPresenter by lazy { MainPresenter(this, this) }
    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun showData(datas: List<Datas>) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {

        databinding.presenter=mPresenter
        databinding.lifecycleOwner = this
        databinding.data = MainViewModel()
        mPresenter.dataBinding = databinding
        databinding.rv.layoutManager = LinearLayoutManager(mActivity)
        var mainDataAdapter = MainDataAdapter<ItemHomeListBinding>(mActivity!!.baseContext)
        databinding.rv.adapter = mainDataAdapter
        mPresenter.getHomeList(true)

    }


}