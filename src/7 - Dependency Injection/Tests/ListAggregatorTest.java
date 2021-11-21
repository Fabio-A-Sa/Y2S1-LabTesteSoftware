package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    class StubDeduplicator implements GenericListDeduplicator {
        @Override
        public List<Integer> deduplicate(List<Integer> list, GenericListSorter genericListSorter) {
            List<Integer> unique = Arrays.asList(1, 2, 4);
            return unique;
        }
    }

    public List<Integer> helper() {

        List<Integer> list = Arrays.asList(1,2,4,2,5);
        return list;
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(helper());

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(helper());

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(helper());

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListDeduplicator deduplicator = new ListDeduplicator();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(helper(), deduplicator);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {

        ListAggregator aggregator = new ListAggregator();
        List<Integer> list = Arrays.asList(-5, -2, -1, -4);
        Integer result = aggregator.max(list);

        Assertions.assertEquals(-1, result);
    }

    @Test
    public void distinct_bug_8726() {

        StubDeduplicator stub = new StubDeduplicator();
        ListAggregator aggregator = new ListAggregator();
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        Integer result = aggregator.distinct(list, stub);

        Assertions.assertEquals(3, result);
    }
}
