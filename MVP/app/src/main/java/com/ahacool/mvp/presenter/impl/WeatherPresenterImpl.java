package com.ahacool.mvp.presenter.impl;

import com.ahacool.mvp.model.WeatherModel;
import com.ahacool.mvp.model.entity.Weather;
import com.ahacool.mvp.model.impl.WeatherModelImpl;
import com.ahacool.mvp.presenter.OnWeatherListener;
import com.ahacool.mvp.presenter.WeatherPresenter;
import com.ahacool.mvp.ui.view.WeatherView;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/22 下午2:40
 */

public class WeatherPresenterImpl implements WeatherPresenter, OnWeatherListener {

    private WeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresenterImpl(WeatherView weatherView) {
        this.weatherView = weatherView;
        weatherModel = new WeatherModelImpl();
    }

    @Override
    public void getWeather(String cityNO) {
        weatherView.showLoading();
        weatherModel.loadWeather(cityNO, this);
    }

    @Override
    public void onSuccess(Weather weather) {
        weatherView.hideLoading();
        weatherView.setWeatherInfo(weather);
    }

    @Override
    public void onError() {
        weatherView.hideLoading();
        weatherView.showError();
    }
}
