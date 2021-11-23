package com.aor.numbers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {

    @Test
    public void test() {

        DivisibleByFilter divisibleByFilter = new DivisibleByFilter();
        Assert.assertEquals(false, divisibleByFilter.accept(0));
        Assert.assertEquals(true, divisibleByFilter.accept(-2));
        Assert.assertEquals(true, divisibleByFilter.accept(3));
        Assert.assertEquals(false, divisibleByFilter.accept(0));
        Assert.assertEquals(true, divisibleByFilter.accept(2342));
    }
}
