package com.bwei.erjigoodscart.net;

/**
 * 作者：王建勋
 * 时间：2017-11-23 08:18
 * 类的用途：
 */

public interface OnNetListener<T> {

    public void onSuccess(T t);

    public void onFailure(Exception e);
}
