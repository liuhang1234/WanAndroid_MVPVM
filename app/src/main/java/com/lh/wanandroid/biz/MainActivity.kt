package com.lh.wanandroid.biz

import android.os.Bundle
import com.lh.wanandroid.R
import com.lh.wanandroid.base.BaseActivity
import com.lh.wanandroid.base.BaseFragment
import com.lh.wanandroid.biz.main.MainFragment

class MainActivity : BaseActivity() {
    override fun getFragment(): BaseFragment? {
        return MainFragment.newInstance()
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getFragmentContentId(): Int {
        return R.id.content
    }

    override fun init(savedInstanceState: Bundle?) {
    }


}
