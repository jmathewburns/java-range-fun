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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static xyz.jmburns.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

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
    public void shouldReturnNonNullSteppedRange() {
        Iterable<Integer> range = Range.of(0, 4, 2);

        assertNotNull(range);
    }

    @Test
    public void shouldReturnNonNullSteppedIterator() {
        Iterable<Integer> range = Range.of(0, 4, 2);

        Iterator<Integer> rangeIterator = range.iterator();

        assertNotNull(rangeIterator);
    }

    @Test
    public void shouldReturnCorrectBasicRangeOfInts() {
        Iterable<Integer> range = Range.of(1, 3);
        int[] expectedIntegers = {1, 2, 3};

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectSteppedRangeOfInts() {
        Iterable<Integer> range = Range.of(0, 4, 2);
        int[] expectedIntegers = {0, 2, 4};

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfIntsWithFluidAPI() {
        Iterable<Integer> range = Range.of(0)
                                        .to(5)
                                        .step(2);
        int[] expectedIntegers = {0, 2, 4};

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfObjectArray() {
        Object[] array = new Object[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfIntArray() {
        int[] array = new int[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfLongArray() {
        long[] array = new long[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfFloatArray() {
        float[] array = new float[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfDoubleArray() {
        double[] array = new double[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfByteArray() {
        byte[] array = new byte[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfCharArray() {
        char[] array = new char[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReturnCorrectRangeOfShortArray() {
        short[] array = new short[6];
        int[] expectedIntegers = { 0, 1, 2, 3, 4, 5, };

        Iterable<Integer> range = Range.of(array);

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }
}
