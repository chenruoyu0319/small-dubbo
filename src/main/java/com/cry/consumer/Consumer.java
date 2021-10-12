package com.cry.consumer;

import com.cry.framework.ProxyFactory;
import com.cry.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String userName = helloService.sayHello("cry777");
        System.out.println(userName);

    }
}
