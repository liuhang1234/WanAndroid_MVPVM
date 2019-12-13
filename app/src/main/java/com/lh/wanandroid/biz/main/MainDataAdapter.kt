package com.lh.wanandroid.biz.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lh.wanandroid.R
import com.lh.wanandroid.adapter.BaseBindViewHolder
import com.lh.wanandroid.adapter.BaseBindingAdapter
import com.lh.wanandroid.data.Datas

class MainDataAdapter<VB :ViewDataBinding>(mContext: Context) : BaseBindingAdapter<Datas, BaseBindViewHolder>(mContext) {

    override fun onCreateVH(parent: ViewGroup, viewType: Int): BaseBindViewHolder {
        val binding = DataBindingUtil.inflate<VB>(
            LayoutInflater.from(mContext),
            R.layout.item_home_list,
            parent,
            false
        )
        return BaseBindViewHolder(binding)    }

    override fun onBindVH(holder: BaseBindViewHolder, position: Int) {
//        val binding = holder.binding
//        binding.setVariable(BR.data, mDataList?.get(position))//绑定数据
//        binding.executePendingBindings()//防止闪烁
    }

}