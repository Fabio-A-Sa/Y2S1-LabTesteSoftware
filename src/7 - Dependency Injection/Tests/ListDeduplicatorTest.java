package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    /**
     *  Não quero que o resultado de "deduplicate" dependa da classe sorter()
     *  Então o deduplicate recebe um GenericListSorted, que tanto pode ser um objecto manipulado (stub) ou não
     */
    class StubSorter implements GenericListSorter {
        @Override
        public List<Integer> sort(List<Integer> list) {
            List<Integer> stub = Arrays.asList(1, 2, 2, 4);
            return stub;
        }
    }

    @Test
    public void deduplicate() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 4);

        ListDeduplicator deduplicator = new ListDeduplicator();
        StubSorter stub = new StubSorter();
        List<Integer> distinct = deduplicator.deduplicate(list, stub);

        Assertions.assertEquals(expected, distinct);
    }
}