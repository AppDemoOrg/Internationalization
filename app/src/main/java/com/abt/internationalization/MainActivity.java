package com.abt.internationalization;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLocaleLanguage();
        setContentView(R.layout.activity_main);
    }

    /*public Locale(String language, String country) {
        this(language, country, "");
    }*/

    private void initLocaleLanguage() {
        //例如,生成English，不限地区的Locale对象
        Locale newLocale = new Locale("en", "");

        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = newLocale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());//更新配置
    }

    /**重启MainActivity*/
    private void restart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
