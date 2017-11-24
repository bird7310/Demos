package com.ahacool.mvp.model;

import com.ahacool.mvp.presenter.OnWeatherListener;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/22 下午2:34
 */

public interface WeatherModel {

    void loadWeather(String cityNO, final OnWeatherListener listener);

}
