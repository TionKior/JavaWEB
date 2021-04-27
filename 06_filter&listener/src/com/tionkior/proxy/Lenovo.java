package com.tionkior.proxy;

/**
 * @ClassName : Lenovo
 * @Author : TionKior
 * @Date : 2021/4/27 17:16
 * @Version : V1.0
 * @Description : 真实类
 */

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {

        System.out.println("花了" + money + "元买了一台联想电脑...");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑...");
    }
}
