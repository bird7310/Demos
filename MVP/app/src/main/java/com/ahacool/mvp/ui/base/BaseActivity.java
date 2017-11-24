package com.ahacool.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/22 下午2:43
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

}
