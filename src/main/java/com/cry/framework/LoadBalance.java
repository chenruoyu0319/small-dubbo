package com.cry.framework;

import java.util.List;
import java.util.Random;

/**
 * 伪随机负载均衡
 */
public class LoadBalance {

    public static URL random(List<URL> list) {
        Random random =new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }

}
