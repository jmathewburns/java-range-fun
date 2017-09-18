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
import static xyz.jmburns.rangefun.ProgressionTestHelper.iteratorReturnsOnlyExpectedIntegers;

public class ReverseProgressionIteratorTest {
    @Test
    public void shouldReturnCorrectReversedRangeIterator() {
        int[] expectedIntegers = { 3, 2, 1, };
        Iterator<Integer> iterator = new ReverseProgressionIterator(3, 1, 1);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(iterator, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectReversedProgressionIterator() {
        int[] expectedIntegers = { 6, 4, 2, };
        Iterator<Integer> iterator = new ReverseProgressionIterator(6, 1, 2);

        assertTrue(iteratorReturnsOnlyExpectedIntegers(iterator, expectedIntegers));
    }

    @Test
    public void malformedProgressionShouldBeEmpty() {
        int high = 0, low = 6, step = 3;
        Iterator<Integer> iterator = new ReverseProgressionIterator(high, low, step);

        boolean empty = !iterator.hasNext();

        assertTrue(empty);
    }

    @Test
    public void equivalentInstancesShouldBeEqual() {
        int high = 6, low = 0, step = 3;
        Iterator<Integer> iterator1 = new ReverseProgressionIterator(high, low, step);
        Iterator<Integer> iterator2 = new ReverseProgressionIterator(high, low, step);

        assertEquals(iterator1, iterator2);
    }

    @Test
    public void nonEquivalentInstancesShouldBeUnequal() {
        int high = 30, low = 15, step = 10;
        Iterator<Integer> iterator1 = new ReverseProgressionIterator(high, low, step + 4);
        Iterator<Integer> iterator2 = new ReverseProgressionIterator(high, low, step);

        assertNotEquals(iterator1, iterator2);
    }

    @Test
    public void equivalentIteratorsShouldReturnEqualHashCodes() {
        int high = 9, low = 5, step = 1;
        Iterator<Integer> iterator1 = new ReverseProgressionIterator(high, low, step);
        Iterator<Integer> iterator2 = new ReverseProgressionIterator(high, low, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertEquals(hash1, hash2);
    }

    @Test
    public void nonEquivalentIteratorsShouldReturnUnequalHashCodes() {
        int high = 3, low = 0, step = 2;
        Iterator<Integer> iterator1 = new ReverseProgressionIterator(high, low - 2, step);
        Iterator<Integer> iterator2 = new ReverseProgressionIterator(high, low, step);

        int hash1 = iterator1.hashCode();
        int hash2 = iterator2.hashCode();

        assertNotEquals(hash1, hash2);
    }
}
