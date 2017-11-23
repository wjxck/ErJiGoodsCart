package com.bwei.erjigoodscart.eventbusevent;

/**
 * 作者：王建勋
 * 时间：2017-11-23 10:22
 * 类的用途：
 */

public class PriceAndCountEvent {
    public int count;
    public int price;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
