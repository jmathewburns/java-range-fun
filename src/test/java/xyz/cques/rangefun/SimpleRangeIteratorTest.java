package xyz.cques.rangefun;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static xyz.cques.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

/**
 * Created by Jacques on 08-08-2017.
 */
public class SimpleRangeIteratorTest {
    @Test
    public void shouldReturnBasicRangeOfExpectedInts() {
        int[] expectedIntegers = { 1, 2, 3, };
        Iterator<Integer> rangeIterator = new SimpleRangeIterator(1, 3, 1);

        assertTrue(rangeReturnsExpectedInts(rangeIterator, expectedIntegers));
    }

    @Test
    public void shouldReturnSteppedRangeOfExpectedInts() {
        int[] expectedIntegers = { 1, 3, 5, };
        Iterator<Integer> rangeIterator = new SimpleRangeIterator(1, 6, 2);

        assertTrue(rangeReturnsExpectedInts(rangeIterator, expectedIntegers));
    }
}
