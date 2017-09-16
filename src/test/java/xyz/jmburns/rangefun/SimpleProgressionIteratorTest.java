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

public class SimpleProgressionIteratorTest {
    @Test
    public void shouldReturnBasicRangeOfExpectedInts() {
        int[] expectedIntegers = { 1, 2, 3, };
        Iterator<Integer> rangeIterator = new SimpleProgressionIterator(1, 3, 1);

        assertTrue(ProgressionTestHelper.progressionReturnsExpectedInts(rangeIterator, expectedIntegers));
    }

    @Test
    public void shouldReturnSteppedRangeOfExpectedInts() {
        int[] expectedIntegers = { 1, 3, 5, };
        Iterator<Integer> rangeIterator = new SimpleProgressionIterator(1, 6, 2);

        assertTrue(ProgressionTestHelper.progressionReturnsExpectedInts(rangeIterator, expectedIntegers));
    }

    @Test
    public void shouldNotHaveNextForMalformedRange() {
        int start = 6;
        int end = 0;
        int step = 3;

        Iterator<Integer> iterator = new SimpleProgressionIterator(start, end, step);

        assertFalse(iterator.hasNext());
    }

    @Test
    public void equivalentIteratorsShouldBeEqual() {
        int start = 6;
        int end = 0;
        int step = 3;

        Iterator<Integer> iterator1 = new SimpleProgressionIterator(start, end, step);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(start, end, step);

        assertEquals(iterator1, iterator2);
    }

    @Test
    public void nonEquivalentIteratorsShouldBeUnequal() {
        int start = 6;
        int end = 0;
        int step = 3;

        Iterator<Integer> iterator1 = new SimpleProgressionIterator(start, end, step + 1);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(start, end, step);

        assertNotEquals(iterator1, iterator2);
    }

    @Test
    public void equivalentIteratorsShouldReturnEqualHashCodes() {
        int start = 6;
        int end = 0;
        int step = 3;

        Iterator<Integer> iterator1 = new SimpleProgressionIterator(start, end, step);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(start, end, step);

        assertEquals(iterator1.hashCode(), iterator2.hashCode());
    }

    @Test
    public void nonEquivalentIteratorsShouldReturnUnequalHashCodes() {
        int start = 6;
        int end = 0;
        int step = 3;

        Iterator<Integer> iterator1 = new SimpleProgressionIterator(start, end, step + 1);
        Iterator<Integer> iterator2 = new SimpleProgressionIterator(start, end, step);

        assertNotEquals(iterator1.hashCode(), iterator2.hashCode());
    }
}