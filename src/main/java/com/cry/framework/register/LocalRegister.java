package com.cry.framework.register;

import java.util.HashMap;
import java.util.Map;

/**
 * 本地注册接口和服务实现类关系
 * TODO: 可增加多版本控制
 */
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void regist(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
       return map.get(interfaceName);
    }
}
