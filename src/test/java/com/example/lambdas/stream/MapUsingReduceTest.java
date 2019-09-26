package com.example.lambdas.stream;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MapUsingReduceTest {

    @Test
    public void emptyList() {
        assertMapped(Function.identity(), Collections.emptyList(), Collections.emptyList());
    }

    /**
     * 元素不变
     */
    @Test
    public void identityMapsToItself() {
        assertMapped((Integer x) -> x, asList(1, 2, 3), asList(1, 2, 3));
    }

    /**
     * 集合元素都 +2
     */
    @Test
    public void incrementingNumbers() {
        assertMapped((Integer x) -> x + 2, asList(1, 2, 3), asList(3, 4, 5));
    }

    /**
     *
     * @param mapper 函数
     * @param input 输入list
     * @param expectedOutput 期待list
     * @param <I> i
     * @param <O> o
     */
    private <I, O> void assertMapped(Function<I, O> mapper, List<I> input, List<O> expectedOutput) {
        /*
         * 经过map方法后是否满足集合中每个值都+2
         */
        List<O> output = StreamSample.map(input.stream(), mapper);
        assertEquals(expectedOutput, output);
        /*
         * 并行流
         */
        List<O> parallelOutput = StreamSample.map(input.parallelStream(), mapper);
        assertEquals(expectedOutput, parallelOutput);
    }

}
