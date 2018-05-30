package com.abt.internationalization;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;

import com.orhanobut.logger.Logger;

import java.lang.reflect.Method;
import java.util.Locale;

/**
 * @描述： @LanguageUtil
 * @作者： @黄卫旗
 * @创建时间： @20/05/2018
 */
public class LanguageUtil {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void changeSystemLanguage(Locale locale) {
        if (locale != null) {
            try {
                Class classActivityManagerNative = Class.forName("android.app.ActivityManagerNative");
                Method getDefault = classActivityManagerNative.getDeclaredMethod("getDefault");
                Object objIActivityManager = getDefault.invoke(classActivityManagerNative);
                Class classIActivityManager = Class.forName("android.app.IActivityManager");
                Method getConfiguration = classIActivityManager.getDeclaredMethod("getConfiguration");
                Configuration config = (Configuration) getConfiguration.invoke(objIActivityManager);
                config.setLocales(new LocaleList(locale));
                Class[] clzParams = {Configuration.class};
                Method updateConfiguration = classIActivityManager.getDeclaredMethod("updatePersistentConfiguration", clzParams);
                updateConfiguration.invoke(objIActivityManager, config);
            } catch (Exception e) {
                e.printStackTrace();
                Logger.d("changeSystemLanguage: " + e.getLocalizedMessage());
            }
        }
    }

    public static void updateLocale(Locale locale) {
        Resources resources = InterApplication.getAppContext().getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        config.locale = locale;
        resources.updateConfiguration(config, dm);
    }
}
