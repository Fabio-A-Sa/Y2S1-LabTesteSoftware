package com.aor.numbers;
import java.util.ArrayList;
import java.util.List;

public class ListFilter {

    private GenericListFilter filter;

    public ListFilter(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {

        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            if (filter.accept(number)) {
                result.add(number);
            }
        }
        return result;
    }
}
