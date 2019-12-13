package com.lh.wanandroid.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseBindViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
    var binding: ViewDataBinding
        internal set

    init {
        this.binding = binding
    }
}
