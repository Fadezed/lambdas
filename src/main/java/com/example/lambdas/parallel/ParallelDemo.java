package com.example.lambdas.parallel;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 描述:
 * 并行处理
 *
 * @author zed
 * @since 2019-09-27 16:47
 */
public class ParallelDemo {
    /**
     * 顺序求列表中数字的平方和
     * @param range range
     * @return int
     */
    public static int sequentialSumOfSquares(IntStream range){
        return range.map(x-> x*x)
                .sum();
    }

    /**
     * 并行处理求和
     * @param range range
     * @return int
     */
    public static int parallelSumOfSquares(IntStream range){
        return range.parallel()
                .map(x->x*x)
                .sum();
    }

    /**
     * 列表中数字相乘 再将结果乘5
     * @param linkedListOfNumbers linkedListOfNumbers
     * @return int
     */
    public static int multiplyThrough(List<Integer> linkedListOfNumbers){
        return linkedListOfNumbers.stream().reduce(5,(acc,x)->x*acc);
    }

    /**
     * 列表中数字相乘 再将结果乘5
     * @param integers list
     * @return int
     */
    public static int multiplyThroughParallel(List<Integer> integers){
        return 5*integers
                .parallelStream()
                .reduce(1,(acc,x)-> x* acc);
    }


}
