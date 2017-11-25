package com.ahacool.mvp.ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ahacool.mvp.R;
import com.ahacool.mvp.model.entity.Weather;
import com.ahacool.mvp.model.entity.WeatherInfo;
import com.ahacool.mvp.presenter.WeatherPresenter;
import com.ahacool.mvp.presenter.impl.WeatherPresenterImpl;
import com.ahacool.mvp.ui.base.BaseActivity;
import com.ahacool.mvp.ui.view.WeatherView;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/22 下午2:43
 */

public class MainActivity extends BaseActivity implements WeatherView, View.OnClickListener {

    private Dialog mLoadingDialog;
    private EditText mCityNOEditTxt;
    private TextView mCityTxtView;
    private TextView mCityNOTextView;
    private TextView mTempTxtView;
    private TextView mWDTxtView;
    private TextView mWSTxtView;
    private TextView mSDTxtView;
    private TextView mTimeTxtView;

    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mCityNOEditTxt = findView(R.id.et_city_no);
        mCityTxtView = findView(R.id.tv_city);
        mCityNOTextView = findView(R.id.tv_city_no);
        mTempTxtView = findView(R.id.tv_temp);
        mWDTxtView = findView(R.id.tv_WD);
        mWSTxtView = findView(R.id.tv_WS);
        mSDTxtView = findView(R.id.tv_SD);
        mTimeTxtView = findView(R.id.tv_time);

        findView(R.id.btn_go).setOnClickListener(this);

        weatherPresenter = new WeatherPresenterImpl(this); //传入WeatherView
        mLoadingDialog = new ProgressDialog(this);
        mLoadingDialog.setTitle("加载天气中...");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go:
                weatherPresenter.getWeather(mCityNOEditTxt.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showLoading() {
        mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        mLoadingDialog.dismiss();
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
        WeatherInfo info = weather.getWeatherinfo();
        mCityTxtView.setText(info.getCity());
        mCityNOTextView.setText(info.getCityid());
        mTempTxtView.setText(info.getTemp());
        mWDTxtView.setText(info.getWD());
        mWSTxtView.setText(info.getWS());
        mSDTxtView.setText(info.getSD());
        mTimeTxtView.setText(info.getTime());
    }
}
