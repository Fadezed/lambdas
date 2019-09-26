package com.example.lambdas.stream;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FilterUsingReduceTest {

    @Test
    public void emptyList() {
        assertFiltered(x -> false, Collections.emptyList(), Collections.emptyList());
    }

    /**
     * 条件始终为true 故集合元素都满足
     */
    @Test
    public void trueReturnsEverything() {
        assertFiltered((Integer x) -> true, asList(1, 2, 3), asList(1, 2, 3));
    }

    /**
     * 条件始终为false 故集合元素都被剔除
     */
    @Test
    public void falseRemovesEverything() {
        assertFiltered((Integer x) -> false, asList(1, 2, 3), Collections.emptyList());
    }

    /**
     * 筛选满足 x>2 的元素
     */
    @Test
    public void filterPartOfList() {
        assertFiltered((Integer x) -> x > 2, asList(1, 2, 3), Collections.singletonList(3));
    }

    /**
     *
     * @param predicate 条件约束
     * @param input 输入集合
     * @param expectedOutput 期待集合
     * @param <I> i
     */
    private <I> void assertFiltered(Predicate<I> predicate, List<I> input, List<I> expectedOutput) {
        /*
         * 经过过滤后集合是否满足期待
         */
        List<I> output = StreamSample.filter(input.stream(), predicate);
        assertEquals(expectedOutput, output);

        List<I> parallelOutput = StreamSample.filter(input.parallelStream(), predicate);
        assertEquals(expectedOutput, parallelOutput);
    }

}
