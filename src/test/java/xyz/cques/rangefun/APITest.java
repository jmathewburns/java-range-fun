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
        //given
        Interval interval = Range.of(1, 3);

        //then
        assertNotNull(interval);
    }

    @Test
    public void shouldReturnNonNullIterator() {
        //given
        Interval interval = Range.of(1, 3);

        //when
        Iterator<Integer> rangeIterator = interval.iterator();

        //then
        assertNotNull(rangeIterator);
    }

    @Test
    public void shouldReturnCorrectBasicRangeOfInts() {
        //given
        Interval interval = Range.of(1, 3);
        int[] expectedIntegers = {1, 2, 3};

        //then
        assertTrue(rangeReturnsExpectedInts(interval, expectedIntegers));
    }
}
