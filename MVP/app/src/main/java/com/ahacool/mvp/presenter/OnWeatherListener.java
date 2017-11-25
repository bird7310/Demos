package com.ahacool.mvp.presenter;


import com.ahacool.mvp.model.entity.Weather;

/**
 * Description: 在Presenter层实现，给Model层回调，更改View层的状态，确保Model层不直接操作View层
 *
 * @author: moto
 * @time: 17/11/22 下午2:38
 */

public interface OnWeatherListener {
    /**
     * 成功时回调
     *
     * @param weather
     */
    void onSuccess(Weather weather);
    /**
     * 失败时回调，简单处理，没做什么
     */
    void onError();

}
