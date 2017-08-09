package xyz.rangefun;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static xyz.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

public class ReverseRangeIteratorTest {
    @Test
    public void shouldReturnReversedRangeOfExpectedInts() {
        int[] expectedIntegers = { 3, 2, 1, };
        Iterator<Integer> rangeIterator = new ReverseRangeIterator(3, 1, 1);

        assertTrue(RangeTestHelper.rangeReturnsExpectedInts(rangeIterator, expectedIntegers));
    }

    @Test
    public void shouldReturnReversedSteppedRangeOfExpectedInts() {
        int[] expectedIntegers = { 6, 4, 2, };
        Iterator<Integer> rangeIterator = new ReverseRangeIterator(6, 1, 2);

        assertTrue(RangeTestHelper.rangeReturnsExpectedInts(rangeIterator, expectedIntegers));
    }
}
