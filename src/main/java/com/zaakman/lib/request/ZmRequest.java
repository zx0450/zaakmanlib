package com.zaakman.lib.request;

import android.app.Application;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZaakMan on 2017/7/26.
 * 封装网络请求
 */

public class ZmRequest {

    private static RequestQueue mRequestQueue = null;

    public static RequestQueue GetRequestQueue(){
        return mRequestQueue;
    }

    /**
     * 操作的回调
     */
    public interface RequestListener {
        void onResponse(JSONObject jsonObject);

        void onError(Exception error);
    }

    /**
     * 初始化
     *
     * @param appContext
     */
    public static void init(Application appContext) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(appContext);
        }
    }


    /**
     * 执行Get操作
     *
     * @param url
     * @param listener
     */
    public void methodGet(String url, RequestListener listener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new GetMethodListener(listener), new ErrorListener(listener));
        mRequestQueue.add(request);
    }

    /**
     * 使用body方法提交数据，数据格式是json
     *
     * @param url
     * @param json
     * @param listener
     */
    public void methodPost(String url, final JSONObject json, RequestListener listener) {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        listener.onResponse(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.onError(e);
                    }
                }, new ErrorListener(listener)) {

            @Override
            public byte[] getBody() throws AuthFailureError {
                return json.toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        mRequestQueue.add(request);
    }


    /**
     * 使用键值对的方法提交参数
     *
     * @param url
     * @param postData
     * @param listener
     */
    public void methodPost(String url, final Map<String, String> postData, RequestListener listener) {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
//                        response.setContentType("text/html; charset=utf-8")
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.optInt("code") != 0) {
                            listener.onError(new Exception(jsonObject.optString("reason")));
                        } else {
                            listener.onResponse(jsonObject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.onError(e);
                    }
//                    catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                        listener.onError(e);
//                    }
                }, new ErrorListener(listener)) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return postData;
            }
        };
        mRequestQueue.add(request);
    }

    /**
     * get方法成功时调用
     */
    private class GetMethodListener implements Response.Listener<JSONObject> {

        private RequestListener listener = null;

        public GetMethodListener(RequestListener listener) {
            this.listener = listener;
        }

        @Override
        public void onResponse(JSONObject response) {
            try {
                if (response.getInt("ErrCode") == 0 && listener != null) {
                    listener.onResponse(response);
                } else {
                    if (listener != null)
                        listener.onError(new Exception(response.optString("reason")));
                }
            } catch (JSONException e) {
                if (listener != null) listener.onError(e);
            }
        }
    }


    /**
     * 访问接口失败时调用
     */
    private class ErrorListener implements Response.ErrorListener {

        private RequestListener listener = null;

        public ErrorListener(RequestListener listener) {
            this.listener = listener;
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            if (listener != null) listener.onError(new Exception(error.toString()));
        }
    }
}
