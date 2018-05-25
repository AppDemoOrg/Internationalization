package com.abt.internationalization;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private boolean mToggle = false;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.change_language) void changeLanguage() {
        if (mToggle) {
            mToggle = false;
            LanguageUtil.changeSystemLanguage(Locale.SIMPLIFIED_CHINESE);
        } else {
            mToggle = true;
            LanguageUtil.changeSystemLanguage(Locale.ENGLISH);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLocaleLanguage();
        // getActionBar().setTitle(R.string.app_language);
    }

    /*public Locale(String language, String country) {
        this(language, country, "");
    }*/

    private void initLocaleLanguage() {
        // 例如,生成English，不限地区的Locale对象
        Locale.setDefault(Locale.ENGLISH);
        Locale newLocale = new Locale(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());

        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = newLocale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());//更新配置
    }

    /**重启MainActivity*/
    public void restart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        this.finish();
    }

}
