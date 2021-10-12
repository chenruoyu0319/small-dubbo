package com.cry.framework.register;

import com.cry.framework.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Chen ruoyu
 * @Description: 远程注册中心服务注册类(通过本地文件模拟)
 * @Date Created in:  2021-10-11 14:48
 * @Modified By:
 */
public class RemoteMapRegister {

    /**
     * {sayHello, [url1, url2...]}
     */
    private static volatile Map<String, List<URL>> REGISTER = new HashMap<>();

    /**
     * 注册
     * @param interfaceName
     * @param url
     */
    public static void regist(String interfaceName, URL url){

        List<URL> list = REGISTER.get(interfaceName);

        if (null != list){
            list.add(url);
        }
        synchronized (RemoteMapRegister.class){
            if (null != list){
                list.add(url);
            }
            list = new ArrayList<>();
            list.add(url);
        }
        REGISTER.put(interfaceName, list);
        // 本地文件模拟注册中心
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        REGISTER = getFile();

        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }


    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
