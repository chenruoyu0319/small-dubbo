package com.cry.provider;

import com.cry.framework.Protocol;
import com.cry.framework.ProtocolFactory;
import com.cry.framework.URL;
import com.cry.framework.register.LocalRegister;
import com.cry.framework.register.RemoteMapRegister;
import com.cry.provider.api.HelloService;
import com.cry.provider.impl.HelloServiceImpl;

/**
 * @Author: Chen ruoyu
 * @Description:
 * @Date Created in:  2021-10-11 14:27
 * @Modified By:
 */
public class Provider {

    /**
     * 服务端容器启动流程: 1.远程注册服务 2.本地注册服务 3.启动tomcat/netty容器
     * @param args
     */
    public static void main(String[] args) {

        // 1.远程注册服务
        // TODO: 读取本地接口获取host, 如有配置则以配置优先
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regist(HelloService.class.getName(), url);

        // 2.本地注册接口和服务实现类关系
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 3.启动容器
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
