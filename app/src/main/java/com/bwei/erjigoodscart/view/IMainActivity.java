package com.bwei.erjigoodscart.view;

import com.bwei.erjigoodscart.bean.GoodsBean;

import java.util.List;

/**
 * 作者：王建勋
 * 时间：2017-11-23 08:34
 * 类的用途：
 */

public interface IMainActivity {
    public void showList(List<GoodsBean.DataBean> groupList, List<List<GoodsBean.DataBean.DatasBean>> childList);
}
