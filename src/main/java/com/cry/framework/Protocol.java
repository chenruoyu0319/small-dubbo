package com.cry.framework;

/**
 * 协议抽象
 */
public interface Protocol {

    /**
     * 容器启动
     * @param url
     */
    void start(URL url);

    /**
     * 协议交互
     * @param url
     * @param invocation
     * @return
     */
    String send(URL url, Invocation invocation);
}
