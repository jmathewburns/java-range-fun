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

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static xyz.jmburns.rangefun.ProgressionTestHelper.iteratorReturnsOnlyExpectedIntegers;

public class SimpleProgressionIteratorTest {
    @Test
    public void shouldReturnCorrectRangeIterator() {
        int[] expectedIntegers = { 1, 2, 3, };
        Iterator<Integer> rangeIterator = new SimpleProgressionIterator(1, 3, 1);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(rangeIterator, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectProgressionIterator() {
        int[] expectedIntegers = { 1, 3, 5, };
        Iterator<Integer> rangeIterator = new SimpleProgressionIterator(1, 6, 2);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(rangeIterator, expectedIntegers));
    }

    @Test
    public void malformedProgressionShouldBeEmpty() {
        int low = 6, high = 0, step = 3;
        Iterator<Integer> iterator = new SimpleProgressionIterator(low, high, step);

        boolean empty = !iterator.hasNext();

        assertTrue(empty);
    }

    @Test
    public void equivalentInstancesShouldBeEqual() {
        int low = 1, high = 8, step = 2;

        Iterator<Integer> iterator1 = new SimpleProgressionIterator(low, high, step);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(low, high, step);

        assertEquals(iterator1, iterator2);
    }

    @Test
    public void nonEquivalentInstancesShouldBeUnequal() {
        int low = 0, high = 24, step = 8;

        Iterator<Integer> iterator1 = new SimpleProgressionIterator(low + 1, high, step);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(low, high, step);

        assertNotEquals(iterator1, iterator2);
    }

    @Test
    public void equivalentInstancesShouldReturnEqualHashCodes() {
        int low = 5, high = 50, step = 3;
        Iterator<Integer> iterator1 = new SimpleProgressionIterator(low, high, step);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(low, high, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertEquals(hash1, hash2);
    }

    @Test
    public void nonEquivalentInstancesShouldReturnUnequalHashCodes() {
        int low = 20, high = 61, step = 30;
        Iterator<Integer> iterator1 = new SimpleProgressionIterator(low, high - 10, step);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(low, high, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertNotEquals(hash1, hash2);
    }
}
