package xyz.cques.rangefun;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jacques on 08-08-2017.
 */
public class RangeImplTest {
    @Test
    public void shouldCreateRangeImplementation() {
        new RangeImpl(1, 2, 3);
    }

    @Test
    public void shouldReturnCorrectIterator() {
        RangeImpl range = new RangeImpl(0, 4, 2);
        int[] expectedIntegers = {0, 2, 4};

        assertTrue(RangeTestHelper.rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReflectGivenValuesInToString() {
        String expected = "RangeImpl { start=0, end=10, step=5 }";
        RangeImpl range = new RangeImpl(0, 10, 5);

        assertEquals(expected, range.toString());
    }

    @Test
    public void shouldBeEqual() {
        RangeImpl range1 = new RangeImpl(0, 10, 5);
        RangeImpl range2 = new RangeImpl(0, 10, 5);

        assertTrue(range1.equals(range2));
    }

    @Test
    public void shouldBeUnEqual() {
        RangeImpl range1 = new RangeImpl(0, 10, 5);
        RangeImpl range2 = new RangeImpl(0, 4, 2);

        assertFalse(range1.equals(range2));
    }

    @Test
    public void shouldReturnSameHashForEqualRanges() {
        RangeImpl range1 = new RangeImpl(0, 10, 5);
        RangeImpl range2 = new RangeImpl(0, 10, 5);

        assertEquals(range1.hashCode(), range2.hashCode());
    }

    @Test
    public void shouldReturnDifferentHashForDifferentRanges() {
        RangeImpl range1 = new RangeImpl(0, 10, 5);
        RangeImpl range2 = new RangeImpl(0, 4, 2);

        assertNotEquals(range1.hashCode(), range2.hashCode());
    }
}
