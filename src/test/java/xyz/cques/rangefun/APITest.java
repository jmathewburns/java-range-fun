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
    public void shouldReturnNonNullBasicRange() {
        Iterable<Integer> range = Range.of(1, 3);

        assertNotNull(range);
    }

    @Test
    public void shouldReturnNonNullBasicIterator() {
        Iterable<Integer> range = Range.of(1, 3);

        Iterator<Integer> rangeIterator = range.iterator();

        assertNotNull(rangeIterator);
    }

    @Test
    public void shouldReturnCorrectBasicRangeOfInts() {
        Iterable<Integer> range = Range.of(1, 3);
        int[] expectedIntegers = {1, 2, 3};

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }
}
