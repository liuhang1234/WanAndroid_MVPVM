package com.lh.wanandroid.biz.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.lh.wanandroid.R
import com.lh.wanandroid.base.BaseFragment
import com.lh.wanandroid.data.Datas
import com.lh.wanandroid.databinding.FragmentMainBinding
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
//        var mAdapter = MainDataAdapter<FragmentMainBinding>(mActivity!!.baseContext)
//        rv.layoutManager=LinearLayoutManager(mActivity, RecyclerView.VERTICAL,false)
//        rv.adapter=mAdapter
        mPresenter.getHomeList(true)
    }


}