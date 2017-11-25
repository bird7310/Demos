package com.ahacool.mvp.utils.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/22 下午2:43
 */
public class VolleyRequest {
    private static RequestQueue mRequestQueue;

    private VolleyRequest() {
    }

    /**
     * @param context ApplicationContext
     */
    public static void buildRequestQueue(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        //... do something
    }

    public static VolleyRequest newInstance() {
        if (mRequestQueue == null) {
            throw new NullPointerException("Call buildRequestQueue method first.");
        }
        //...
        return new VolleyRequest();
    }

    /**
     * @param url
     * @param clazz
     * @param listener
     * @param errorListener
     * @return
     */
    public <T> GsonRequest<T> newGsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                                             Response.ErrorListener errorListener) {
        GsonRequest<T> request = new GsonRequest<T>(url, clazz, listener, errorListener);
        mRequestQueue.add(request);
        return request;
    }
}
