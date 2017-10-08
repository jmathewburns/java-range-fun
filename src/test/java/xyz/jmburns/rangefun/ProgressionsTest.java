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

import static org.junit.jupiter.api.Assertions.*;
import static xyz.jmburns.rangefun.ProgressionTestHelper.progressionReturnsOnlyExpectedIntegers;

class ProgressionsTest {
    @Test
    void shouldReturnNonNullBasicRange() {
        Progression range = Progressions.range(1, 3);

        assertNotNull(range);
    }
    
    @Test
    void shouldReturnNonNullProgression() {
        Progression progression = Progressions.progression(0, 4, 2);

        assertNotNull(progression);
    }

    @Test
    void shouldReturnCorrectRange() {
        Progression range = Progressions.range(1, 3);
        int[] expected = {1, 2, 3};

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectProgression() {
        Progression progression = Progressions.progression(0, 4, 2);
        int[] expected = {0, 2, 4};

        assertTrue(progressionReturnsOnlyExpectedIntegers(progression, expected));
    }

    @Test
    void shouldReturnCorrectCount() {
        Progression count = Progressions.count(4);
        int[] expected = {0, 1, 2, 3};

        assertTrue(progressionReturnsOnlyExpectedIntegers(count, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfObjectArray() {
        Object[] array = new Object[6];
        int[] expected = { 0, 1, 2, 3, 4, 5, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfIntArray() {
        int[] array = new int[6];
        int[] expected = { 0, 1, 2, 3, 4, 5, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfLongArray() {
        long[] array = new long[6];
        int[] expected = { 0, 1, 2, 3, 4, 5, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfFloatArray() {
        float[] array = new float[6];
        int[] expected = { 0, 1, 2, 3, 4, 5, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfDoubleArray() {
        double[] array = new double[3];
        int[] expected = { 0, 1, 2, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfByteArray() {
        byte[] array = new byte[1];
        int[] expected = { 0, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfCharArray() {
        char[] array = new char[5];
        int[] expected = { 0, 1, 2, 3, 4, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }

    @Test
    void shouldReturnCorrectRangeOfShortArray() {
        short[] array = new short[4];
        int[] expected = { 0, 1, 2, 3, };

        Progression range = Progressions.indices(array);

        assertTrue(progressionReturnsOnlyExpectedIntegers(range, expected));
    }
}
