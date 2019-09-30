package com.example.lambdas.parallel;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuggyReduceTest {

    @Test
    public void sample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int result = ParallelDemo.multiplyThrough(numbers);
        assertEquals(30, result);
    }

}
