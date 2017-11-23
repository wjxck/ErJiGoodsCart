package com.bwei.erjigoodscart.presenter;

import com.bwei.erjigoodscart.bean.GoodsBean;
import com.bwei.erjigoodscart.model.IMainModel;
import com.bwei.erjigoodscart.model.MainModel;
import com.bwei.erjigoodscart.net.OnNetListener;
import com.bwei.erjigoodscart.view.IMainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：王建勋
 * 时间：2017-11-23 08:32
 * 类的用途：
 */

public class MainPresenter {

    private final IMainModel iMainModel;
    private final IMainActivity iMainActivity;

    public MainPresenter(IMainActivity iMainActivity) {
        iMainModel = new MainModel();
        this.iMainActivity = iMainActivity;
    }

    public void getGoods(){
        iMainModel.getGoods(new OnNetListener<GoodsBean>() {
            @Override
            public void onSuccess(GoodsBean goodsBean) {
                List<GoodsBean.DataBean> groupData = goodsBean.getData();
                List<List<GoodsBean.DataBean.DatasBean>> childList = new ArrayList<List<GoodsBean.DataBean.DatasBean>>();
                for (int i = 0; i < groupData.size(); i++) {
                    List<GoodsBean.DataBean.DatasBean> childData = groupData.get(i).getDatas();
                    childList.add(childData);
                }
                iMainActivity.showList(groupData,childList);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
