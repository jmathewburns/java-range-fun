package xyz.cques.rangefun;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static xyz.cques.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

/**
 * Created by Jacques on 2017/06/20.
 */
public class APITest {
    @Test
    public void shouldReturnNonNullRange() {
        Interval interval = Range.of(1, 3);

        assertNotNull(interval);
    }

    @Test
    public void shouldReturnNonNullIterator() {
        Interval interval = Range.of(1, 3);

        Iterator<Integer> rangeIterator = interval.iterator();

        assertNotNull(rangeIterator);
    }

    @Test
    public void shouldReturnCorrectBasicRangeOfInts() {
        Interval interval = Range.of(1, 3);
        int[] expectedIntegers = {1, 2, 3};

        assertTrue(rangeReturnsExpectedInts(interval, expectedIntegers));
    }
}
