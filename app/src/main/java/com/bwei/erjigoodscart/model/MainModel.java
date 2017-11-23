package com.bwei.erjigoodscart.model;

import android.os.Handler;
import android.os.Looper;

import com.bwei.erjigoodscart.bean.GoodsBean;
import com.bwei.erjigoodscart.net.Api;
import com.bwei.erjigoodscart.net.HttpUtils;
import com.bwei.erjigoodscart.net.OnNetListener;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 作者：王建勋
 * 时间：2017-11-23 08:22
 * 类的用途：
 */

public class MainModel implements IMainModel {
    private Handler handler = new Handler(Looper.getMainLooper());

    public void getGoods(final OnNetListener<GoodsBean> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onNetListener.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final GoodsBean goodsBean = new Gson().fromJson(string, GoodsBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(goodsBean);
                    }
                });
            }
        });
    }
}
