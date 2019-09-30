package com.example.lambdas.parallel;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SerialToParallelTest {

    @Test
    public void testSerialToParallel() {
        IntStream range = IntStream.range(0, 100);
        assertEquals(328350, ParallelDemo.parallelSumOfSquares(range));
    }

}
