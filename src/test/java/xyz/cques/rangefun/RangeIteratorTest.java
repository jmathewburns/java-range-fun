package xyz.cques.rangefun;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static xyz.cques.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

/**
 * Created by Jacques on 08-08-2017.
 */
public class RangeIteratorTest {
    @Test
    public void shouldReturnExpectedInts() {
        int[] expectedIntegers = { 1, 2, 3, };
        Iterator<Integer> rangeIterator = new RangeIterator(1, 3);

        assertTrue(rangeReturnsExpectedInts(rangeIterator, expectedIntegers));
    }
}
