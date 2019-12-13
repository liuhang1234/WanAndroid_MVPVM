package com.lh.wanandroid.base

import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    private var clearedListener: ViewModelClearedListener? = null

    fun clearedListener(clearedListener: ViewModelClearedListener) {
        this.clearedListener = clearedListener
    }
    override fun onCleared() {
        super.onCleared()
        clearedListener?.onCleared()
    }
    interface ViewModelClearedListener {
        fun onCleared()
    }


}