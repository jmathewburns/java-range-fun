package xyz.jmburns.rangefun;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static xyz.jmburns.rangefun.ProgressionTestHelper.iteratorReturnsOnlyExpectedIntegers;

public class ProgressionIteratorTest {
    @Test
    public void shouldReturnCorrectReversedRangeIterator() {
        int[] expectedIntegers = { 3, 2, 1, };
        Iterator<Integer> iterator = ProgressionIterator.descending(3, 1, 1);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(iterator, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectReversedProgressionIterator() {
        int[] expectedIntegers = { 6, 4, 2, };
        Iterator<Integer> iterator = ProgressionIterator.descending(6, 1, 2);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(iterator, expectedIntegers));
    }

    @Test
    public void malformedDescendingProgressionShouldBeEmpty() {
        int high = 0, low = 6, step = 3;
        Iterator<Integer> iterator = ProgressionIterator.descending(high, low, step);

        boolean empty = !iterator.hasNext();

        assertTrue(empty);
    }

    @Test
    public void malformedAscendingProgressionShouldBeEmpty() {
        int low = 6, high = 0, step = 3;
        Iterator<Integer> iterator = ProgressionIterator.ascending(low, high, step);

        boolean empty = !iterator.hasNext();

        assertTrue(empty);
    }

    @Test
    public void equivalentInstancesShouldBeEqual() {
        int high = 6, low = 0, step = 3;
        Iterator<Integer> iterator1 = ProgressionIterator.descending(high, low, step);
        Iterator<Integer> iterator2 = ProgressionIterator.descending(high, low, step);

        assertEquals(iterator1, iterator2);
    }

    @Test
    public void nonEquivalentInstancesShouldBeUnequal() {
        int high = 30, low = 15, step = 10;
        Iterator<Integer> iterator1 = ProgressionIterator.descending(high, low, step + 4);
        Iterator<Integer> iterator2 = ProgressionIterator.descending(high, low, step);

        assertNotEquals(iterator1, iterator2);
    }
    
    @Test
    public void shouldReturnCorrectRangeIterator() {
        int[] expectedIntegers = { 1, 2, 3, };
        Iterator<Integer> rangeIterator = ProgressionIterator.ascending(1, 3, 1);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(rangeIterator, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectProgressionIterator() {
        int[] expectedIntegers = { 1, 3, 5, };
        Iterator<Integer> rangeIterator = ProgressionIterator.ascending(1, 6, 2);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(rangeIterator, expectedIntegers));
    }
    
    @Test
    public void equivalentInstancesShouldReturnEqualHashCodes() {
        int low = 5, high = 50, step = 3;
        Iterator<Integer> iterator1 = ProgressionIterator.ascending(low, high, step);
        Iterator<Integer> iterator2 = ProgressionIterator.ascending(low, high, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertEquals(hash1, hash2);
    }

    @Test
    public void nonEquivalentInstancesShouldReturnUnequalHashCodes() {
        int low = 20, high = 61, step = 30;
        Iterator<Integer> iterator1 = ProgressionIterator.ascending(low, high - 10, step);
        Iterator<Integer> iterator2 = ProgressionIterator.ascending(low, high, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertNotEquals(hash1, hash2);
    }
}