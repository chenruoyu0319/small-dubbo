package com.cry.framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Chen ruoyu
 * @Description:
 * @Date Created in:  2021-10-11 20:04
 * @Modified By:
 */
public class PropertiesUtil {

    public static String getProperties(String propertiesFilePath,String propertiesName){
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream(propertiesFilePath);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String protocolName = properties.getProperty(propertiesName);
        return protocolName;
    }
}
