package com.example.lambdas.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 斐波那契数列
 *
 * @author zed
 * @since 2019-09-27 11:54
 */
public class Fibonacci {
    private final Map<Integer,Long> cache;

    /**
     * 构造方法
     */
    public Fibonacci(){
        cache = new HashMap<>();
        cache.put(0,0L);
        cache.put(1,1L);
    }

    /**
     * 使用map computeIfAbsent 实现斐波那契数列
     * @param x x
     * @return long
     */
    public long fibonacci(int x){
        return cache.computeIfAbsent(x,n ->fibonacci(n-1)+fibonacci(n -2));
    }
}
