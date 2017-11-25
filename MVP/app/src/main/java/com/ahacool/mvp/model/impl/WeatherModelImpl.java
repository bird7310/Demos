package com.ahacool.mvp.model.impl;

import com.ahacool.mvp.model.WeatherModel;
import com.ahacool.mvp.model.entity.Weather;
import com.ahacool.mvp.presenter.OnWeatherListener;
import com.ahacool.mvp.utils.Utils;
import com.ahacool.mvp.utils.volley.VolleyRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/22 下午2:38
 */

public class WeatherModelImpl implements WeatherModel {
    @Override
    public void loadWeather(String cityNO, final OnWeatherListener listener) {
        VolleyRequest.newInstance().newGsonRequest("http://www.weather.com.cn/data/sk/" + cityNO + ".html",
                Weather.class, new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {

                        Utils.delay(1000);

                        if (weather != null) {
                            listener.onSuccess(weather);
                        } else {
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }
}
