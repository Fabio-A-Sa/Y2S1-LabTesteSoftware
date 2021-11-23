package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFilterTest {

    @Test
    public void filter() {

        List<Integer> numbers = Arrays.asList(-3, 2, 0, -5, 2, 6, -5, 0, 2, -2, -6, 0);
        ListFilter positiveFilter = new ListFilter(new PositiveFilter());
        ListFilter divisibleFilter = new ListFilter(new DivisibleByFilter());

        List<Integer> resultPositive = positiveFilter.filter(numbers);
        List<Integer> expectedPositive = Arrays.asList(2, 0, 2, 6, 0, 2, 0);
        Assertions.assertEquals(resultPositive, expectedPositive);

        List<Integer> resultNotNull = divisibleFilter.filter(numbers);
        List<Integer> expectedNotNull = Arrays.asList(-3, 2, -5, 2, 6, -5, 2, -2, -6);
        Assertions.assertEquals(resultNotNull, expectedNotNull);

    }

    @Test
    public void usingStubs() {

        ListFilter listFilter = Mockito.mock(ListFilter.class);
        Mockito.when(listFilter.filter(Mockito.anyList()))
                .thenReturn(Arrays.asList(0, 0, 1, 2));

        List<Integer> numbers = Arrays.asList(-3, 2, 0, -5, 2, 6, -5, 0, 2, -2, -6, 0);
        List<Integer> expected = Arrays.asList(0, 0, 1, 2);
        List<Integer> result = listFilter.filter(numbers); // é independente do que colocar aqui

        Assertions.assertEquals(result, expected);
    }
}