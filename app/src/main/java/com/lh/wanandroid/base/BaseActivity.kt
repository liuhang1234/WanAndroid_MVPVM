package com.lh.wanandroid.base

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.lh.wanandroid.utils.ActivityManagerPool
import com.lh.wanandroid.utils.ActivityUtils
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import org.greenrobot.eventbus.EventBus
import java.lang.ref.WeakReference

abstract class BaseActivity : RxAppCompatActivity() {
    private var weakRefActivity: WeakReference<Activity>? = null
    protected var activity: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weakRefActivity = WeakReference(this)
        ActivityManagerPool.getActivityManage().add(weakRefActivity)
        setContentView(setLayoutId())
        addFragmentToActivity()
        init(savedInstanceState)
    }

    abstract fun getFragment(): BaseFragment<*>?
    abstract fun setLayoutId(): Int
    abstract fun getFragmentContentId(): Int
    abstract fun init(savedInstanceState: Bundle?): Unit


    // 添加fragment
    fun addFragmentToActivity() {
        var fragment: Fragment? = supportFragmentManager.findFragmentById(getFragmentContentId())
        if (fragment == null) {
            fragment = getFragment()
            if (fragment != null){
                ActivityUtils.addFragmenttoActivity(supportFragmentManager, fragment,getFragmentContentId())
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        activity = null
        ActivityManagerPool.getActivityManage().remove(weakRefActivity)
    }

    override fun getResources(): Resources {
        var res = super.getResources()
        var configuration = Configuration()
        configuration.setToDefaults()
        res.updateConfiguration(configuration,res.displayMetrics)
        return res
    }
}