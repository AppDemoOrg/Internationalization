package com.abt.internationalization;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @描述：     @MainActivity
 * @作者：     @黄卫旗
 * @创建时间： @21/05/2018
 */
public class MainActivity extends AppCompatActivity {

    // 中文 英文 日语 德语
    private static final String[] language = {"zh_CN", "en", "ja", "de"};
    public static final String CHINESE = language[0];
    public static final String ENGLISH = language[1];

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.english) void english() {
        Locale locale = new Locale(ENGLISH);
        LanguageUtil.updateLocale(locale);
        restart();
        //LanguageUtil.changeSystemLanguage(Locale.ENGLISH);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.chinese) void chinese() {
        Locale locale = new Locale(CHINESE);
        LanguageUtil.updateLocale(locale);
        restart();
        //LanguageUtil.changeSystemLanguage(Locale.CHINESE);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.restart) void restart() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        this.finish(); /**重启MainActivity*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLocaleLanguage();
    }

    private void initLocaleLanguage() {
        Locale.setDefault(Locale.ENGLISH);
        Locale newLocale = new Locale(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
        LanguageUtil.updateLocale(newLocale);
    }

}
