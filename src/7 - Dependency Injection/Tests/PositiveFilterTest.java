package com.aor.numbers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    @Test
    public void test() {

        PositiveFilter positiveFilter = new PositiveFilter();
        Assert.assertEquals(true, positiveFilter.accept(0));
        Assert.assertEquals(false, positiveFilter.accept(-1));
        Assert.assertEquals(true, positiveFilter.accept(2323));
        Assert.assertEquals(false, positiveFilter.accept(-134));
    }
}