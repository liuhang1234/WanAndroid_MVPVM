package com.lh.wanandroid.http

import com.lh.wanandroid.base.BaseFragment
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TransformUtils {
    companion object {
        fun <T> defaultSchedulers(): ObservableTransformer<T, T> {
            return ObservableTransformer { tObservable ->
                tObservable.subscribeOn(Schedulers.io()).observeOn(
                    AndroidSchedulers.mainThread()
                )
            }
        }
    }
}