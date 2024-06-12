package com.shq.demo.stock.service;

public interface HandlerAdapter {

    /**
     * 判断是否可用，替代if的一种写法，用if的话，当新增一种适配器，就要修改if逻辑增加分支
     * @param handler
     * @return
     */
    boolean support(Object handler);

    Object handler();

}
