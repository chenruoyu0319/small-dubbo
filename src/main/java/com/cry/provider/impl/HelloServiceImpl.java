package com.cry.provider.impl;

import com.cry.provider.api.HelloService;

/**
 * @Author: Chen ruoyu
 * @Description:
 * @Date Created in:  2021-10-11 14:31
 * @Modified By:
 */
public class HelloServiceImpl implements HelloService {

    private String HELLO = "Hello";

    /**
     * 服务提供者方法1
     *
     * @param userName
     * @return
     */
    @Override
    public String sayHello(String userName) {
        return HELLO + userName;
    }
}
