package com.ahacool.mvp;

import android.app.Application;

import com.ahacool.mvp.utils.volley.VolleyRequest;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/24 下午8:07
 */

public class MVPApplication extends Application {

    private static MVPApplication sInstance;

    public MVPApplication() {
        sInstance = this;
    }

    public static Application getContext() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}
