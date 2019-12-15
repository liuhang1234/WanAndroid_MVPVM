package com.lh.wanandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lh.wanandroid.BR
import com.lh.wanandroid.R
import com.lh.wanandroid.data.Datas

class MainDataAdapter(mContext: Context) :BaseBindingAdapter<Datas,BaseBindViewHolder>(mContext) {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): BaseBindViewHolder {
        var inflate = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_home_list,
            parent,
            false
        )
        return BaseBindViewHolder(inflate)
    }

    override fun onBindVH(holder: BaseBindViewHolder, position: Int) {
        val binding = holder.binding
        binding.setVariable(BR.aaaaa,mDataList!![position])
        binding.executePendingBindings()

    }
}