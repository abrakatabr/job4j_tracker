package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunction() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(3, 6, x -> 3 * Math.pow(x, 2) + 5 * x + 3);
        List<Double> expected = Arrays.asList(45D, 71D, 103D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunction() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(2, x) + 5);
        List<Double> expected = Arrays.asList(9D, 13D, 21D);
        assertThat(result).containsAll(expected);
    }
}