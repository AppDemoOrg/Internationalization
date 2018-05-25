package com.abt.internationalization;

import android.app.Application;
import android.content.Context;

/**
 * @描述： @InterApplication
 * @作者： @黄卫旗
 * @创建时间： @26/05/2018
 */
public class InterApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
