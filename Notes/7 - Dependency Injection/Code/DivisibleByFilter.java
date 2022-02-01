package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {

    @Override
    public boolean accept(Integer number) {
        return number != 0 ;
    }
}
