package com.shq.demo.stock.service;

public class TestHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean support(Object handler) {
        return false;
    }

    @Override
    public Object handler() {
        return null;
    }
}
