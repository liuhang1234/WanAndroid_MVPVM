package com.lh.wanandroid.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingAdapter<T, VH : RecyclerView.ViewHolder>(var mContext: Context) :
    RecyclerView.Adapter<VH>() {
    var mDataList: MutableList<T>? =null

    init {
        mDataList = ArrayList()
    }
    override fun getItemCount(): Int {
        return mDataList!!.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return onCreateVH(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindVH(holder, position)
    }

    /**
     * Author: MrGao
     * CreateTime: 2018/4/6 17:12
     * MethodName:
     * Des：刷新数据
     * Params：
     * Return:
     */
    fun onRefreshData(list: List<T>) {
        if (mDataList != null) {
            mDataList!!.clear()
            mDataList!!.addAll(list)
            notifyDataSetChanged()
        }
    }

    fun onLoadMoreData(list: List<T>?) {
        if (mDataList != null && list != null) {
            mDataList!!.addAll(list)
            notifyDataSetChanged()
        }
    }


    abstract fun onCreateVH(parent: ViewGroup, viewType: Int): VH

    abstract fun onBindVH(holder: VH, position: Int)
}