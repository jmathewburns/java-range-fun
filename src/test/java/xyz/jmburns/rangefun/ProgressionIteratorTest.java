/*
 * Copyright 2017 Jacques Burns
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to do so, subject
 * to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package xyz.jmburns.rangefun;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static xyz.jmburns.rangefun.ProgressionTestHelper.iteratorReturnsOnlyExpectedIntegers;

class ProgressionIteratorTest {
    @Test
    void shouldReturnCorrectReversedRangeIterator() {
        int[] expectedIntegers = { 3, 2, 1, };
        Iterator<Integer> iterator = ProgressionIterator.descending(3, 1, 1);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(iterator, expectedIntegers));
    }

    @Test
    void shouldReturnCorrectReversedProgressionIterator() {
        int[] expectedIntegers = { 6, 4, 2, };
        Iterator<Integer> iterator = ProgressionIterator.descending(6, 1, 2);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(iterator, expectedIntegers));
    }

    @Test
    void malformedDescendingProgressionShouldBeEmpty() {
        int high = 0, low = 6, step = 3;
        Iterator<Integer> iterator = ProgressionIterator.descending(high, low, step);

        boolean empty = !iterator.hasNext();

        assertTrue(empty);
    }

    @Test
    void malformedAscendingProgressionShouldBeEmpty() {
        int low = 6, high = 0, step = 3;
        Iterator<Integer> iterator = ProgressionIterator.ascending(low, high, step);

        boolean empty = !iterator.hasNext();

        assertTrue(empty);
    }

    @Test
    void equivalentInstancesShouldBeEqual() {
        int high = 6, low = 0, step = 3;
        Iterator<Integer> iterator1 = ProgressionIterator.descending(high, low, step);
        Iterator<Integer> iterator2 = ProgressionIterator.descending(high, low, step);

        assertEquals(iterator1, iterator2);
    }

    @Test
    void nonEquivalentInstancesShouldBeUnequal() {
        int high = 30, low = 15, step = 10;
        Iterator<Integer> iterator1 = ProgressionIterator.descending(high, low, step + 4);
        Iterator<Integer> iterator2 = ProgressionIterator.descending(high, low, step);

        assertNotEquals(iterator1, iterator2);
    }
    
    @Test
    void shouldReturnCorrectRangeIterator() {
        int[] expectedIntegers = { 1, 2, 3, };
        Iterator<Integer> rangeIterator = ProgressionIterator.ascending(1, 3, 1);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(rangeIterator, expectedIntegers));
    }

    @Test
    void shouldReturnCorrectProgressionIterator() {
        int[] expectedIntegers = { 1, 3, 5, };
        Iterator<Integer> rangeIterator = ProgressionIterator.ascending(1, 6, 2);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(rangeIterator, expectedIntegers));
    }
    
    @Test
    void equivalentInstancesShouldReturnEqualHashCodes() {
        int low = 5, high = 50, step = 3;
        Iterator<Integer> iterator1 = ProgressionIterator.ascending(low, high, step);
        Iterator<Integer> iterator2 = ProgressionIterator.ascending(low, high, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertEquals(hash1, hash2);
    }

    @Test
    void nonEquivalentInstancesShouldReturnUnequalHashCodes() {
        int low = 20, high = 61, step = 30;
        Iterator<Integer> iterator1 = ProgressionIterator.ascending(low, high - 10, step);
        Iterator<Integer> iterator2 = ProgressionIterator.ascending(low, high, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertNotEquals(hash1, hash2);
    }
}