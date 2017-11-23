package com.bwei.erjigoodscart.model;

import com.bwei.erjigoodscart.bean.GoodsBean;
import com.bwei.erjigoodscart.net.OnNetListener;

/**
 * 作者：王建勋
 * 时间：2017-11-23 08:31
 * 类的用途：
 */

public interface IMainModel {
    public void getGoods(OnNetListener<GoodsBean> onNetListener);
}
