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

        PositiveFilter positiveFilter = Mockito.mock(PositiveFilter.class);
        Mockito.when(positiveFilter.accept(Mockito.anyInt()))
                .thenReturn(false);

        ListFilter listFilter = new ListFilter(positiveFilter);
        List<Integer> numbers = Arrays.asList(3, 2, 0, 5, 2, 6, 5, 0, 2, 2, 6, 0);
        List<Integer> expected = Arrays.asList();

        // é independente do valor do filtro --> só está a analisar a função do listFilter()
        List<Integer> result = listFilter.filter(numbers);

        Assertions.assertEquals(result, expected);
    }
}