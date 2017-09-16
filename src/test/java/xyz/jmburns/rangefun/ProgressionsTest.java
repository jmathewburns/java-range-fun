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

import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static xyz.jmburns.rangefun.ProgressionTestHelper.progressionReturnsExpectedInts;

public class ProgressionsTest {
    @Test
    public void shouldReturnNonNullBasicRange() {
        Iterable<Integer> range = Progressions.range(1, 3);

        assertNotNull(range);
    }

    @Test
    public void shouldReturnNonNullBasicIterator() {
        Iterable<Integer> range = Progressions.range(1, 3);

        Iterator<Integer> rangeIterator = range.iterator();

        assertNotNull(rangeIterator);
    }

    @Test
    public void shouldReturnNonNullSteppedRange() {
        Iterable<Integer> range = Progressions.progression(0, 4, 2);

        assertNotNull(range);
    }

    @Test
    public void shouldReturnNonNullSteppedIterator() {
        Iterable<Integer> range = Progressions.progression(0, 4, 2);

        Iterator<Integer> rangeIterator = range.iterator();

        assertNotNull(rangeIterator);
    }

    @Test
    public void shouldReturnCorrectRange() {
        Iterable<Integer> range = Progressions.range(1, 3);
        int[] expectedIntegers = {1, 2, 3};

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectProgression() {
        Iterable<Integer> range = Progressions.progression(0, 4, 2);
        int[] expectedIntegers = {0, 2, 4};

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfObjectArray() {
        Object[] array = new Object[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfIntArray() {
        int[] array = new int[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfLongArray() {
        long[] array = new long[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfFloatArray() {
        float[] array = new float[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfDoubleArray() {
        double[] array = new double[3];
        int[] expectedIntegers = { 0, 1, 2, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfByteArray() {
        byte[] array = new byte[1];
        int[] expectedIntegers = { 0, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfCharArray() {
        char[] array = new char[5];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfShortArray() {
        short[] array = new short[4];
        int[] expectedIntegers = { 0, 1, 2, 3, };

        Iterable<Integer> range = Progressions.range(array);

        assertTrue(progressionReturnsExpectedInts(range, expectedIntegers));
    }
}
