package com.ahacool.mvp.ui.view;

import com.ahacool.mvp.model.entity.Weather;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/22 下午2:41
 */

public interface WeatherView {

    void showLoading();

    void hideLoading();

    void showError();

    void setWeatherInfo(Weather weather);
}
