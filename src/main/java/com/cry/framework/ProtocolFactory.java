package com.cry.framework;

import com.cry.framework.protocol.dubbo.DubboProtocol;
import com.cry.framework.protocol.http.HttpProtocol;
import com.cry.framework.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 协议工厂类,根据配置选择对应协议
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {

        String protocolName = PropertiesUtil.getProperties("/protocol.properties",
                "protocolName");
        // 默认服务提供者使用http协议
        if (null == protocolName|| "".equals(protocolName)) {
            protocolName = "http";
        }
        switch (protocolName) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
