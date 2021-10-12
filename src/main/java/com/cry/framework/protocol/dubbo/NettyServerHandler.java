package com.cry.framework.protocol.dubbo;

import com.cry.framework.Invocation;
import com.cry.framework.register.LocalRegister;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 读取到msg
        Invocation invocation = (Invocation) msg;
        // 从本地注册中心获得服务实现类
        Class serviceImpl = LocalRegister.get(invocation.getInterfaceName());
        // 获取方法
        Method method = serviceImpl.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        // 执行方法
        String result = (String)method.invoke(serviceImpl.newInstance(), invocation.getParams());
        System.out.println("Netty-------------" + result);
        // 送回客户端
        ctx.writeAndFlush("Netty:" + result);
    }
}
