package com.lh.wanandroid.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lh.wanandroid.App


/// MC context
abstract class BasePresenter<MC, V : IView>(var mContext: MC?, var mView: V?) : IPresenter {

    protected fun <T : BaseViewModel> viewModelProvider(modelClass: Class<T>): T {
        //仅支持Fragment不知处Activity
        val viewModel: BaseViewModel
        if (mContext is BaseFragment<*>) {
            viewModel = ViewModelProviders.of(mContext as BaseFragment<ViewDataBinding>).get(modelClass);
        } else {
            viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(App.instance!!)
                .create(modelClass)
        }
        viewModel.clearedListener(object : BaseViewModel.ViewModelClearedListener {
            override fun onCleared() {
                dispost();
            }

        })

        return viewModel
    }

    private fun dispost() {
        mContext = null
        mView = null
    }

}