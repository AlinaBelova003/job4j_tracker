package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionRangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = FunctionRange.diapason(2, 4, x -> x * x + 1);
        List<Double> expected = Arrays.asList(5D, 10D);
        assertThat(result, is(expected));
    }

    @Test
    public void exponentialFunctionThenExponentialResult() {
        List<Double> result = FunctionRange.diapason(6, 8, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(729D, 2187D);
        assertThat(result, is(expected));
    }
}