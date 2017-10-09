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

class ProgressionTest {
    @Test
    void shouldCreateProgressionWithoutException() {
        new Progression(1, 2, 3);
    }

    @Test
    void shouldReturnCorrectIterator() {
        Progression progression = new Progression(0, 4, 2);
        int[] expectedIntegers = {0, 2, 4};

        assertTrue(progressionReturnsOnlyExpectedIntegers(progression, expectedIntegers));
    }

    @Test
    void simpleProgressionShouldContainInteger() {
        Progression progression = new Progression(0, 6, 3);
        assertTrue(progression.contains(3));
    }

    @Test
    void simpleProgressionShouldNotContainInteger() {
        Progression progression = new Progression(0, 100, 20);
        assertFalse(progression.contains(50));
    }

    @Test
    void reverseProgressionShouldContainInteger() {
        Progression progression = new Progression(6, 0, 3);
        assertTrue(progression.contains(3));
    }

    @Test
    void reverseProgressionShouldNotContainInteger() {
        Progression progression = new Progression(50, 0, 2);
        assertFalse(progression.contains(25));
    }

    @Test
    void progressionShouldContainNegativeInteger() {
        Progression progression = new Progression(-10, 3, 2);
        assertTrue(progression.contains(-8));
    }

    @Test
    void reverseProgressionShouldContainNegativeInteger() {
        Progression progression = new Progression(5, -5, 1);
        assertTrue(progression.contains(-3));
    }

    @Test
    void shouldGetCorrectIntegerAtSimpleIndex() {
        Progression progression = new Progression(10, 20, 2);

        int integerAtIndex = progression.get(2);

        assertEquals(14, integerAtIndex);
    }

    @Test
    void shouldGetCorrectIntegerAtReversedIndex() {
        Progression progression = new Progression(5, 1, 3);

        int integerAtIndex = progression.get(1);

        assertEquals(2, integerAtIndex);
    }

    @Test
    void shouldThrowExceptionForNegativeIndex() {
        Progression progression = new Progression(10, 20, 2);

        assertThrows(IndexOutOfBoundsException.class, () -> progression.get(-1));
    }

    @Test
    void shouldThrowExceptionForTooHighIndex() {
        Progression progression = new Progression(10, 20, 2);

        int length = progression.length();
        assertThrows(IndexOutOfBoundsException.class, () -> progression.get(length + 2));
    }

    @Test
    void reversedProgressionShouldReturnCorrectIntegers() {
        int[] expected = { 7, 6, 5, 4, 3, 2, };
        Progression initial = new Progression(2, 7, 1);

        Progression reversed = initial.reverse();

        assertTrue(progressionReturnsOnlyExpectedIntegers(reversed, expected));
    }

    @Test
    void shouldCalculateCorrectLength() {
        Progression progression = new Progression(0, 30, 5);
        int expected = 7;

        int length = progression.length();

        assertEquals(expected, length);
    }

    @Test
    void shouldCalculateCorrectLengthForNegativeStart() {
        Progression progression = new Progression(-5, 30, 5);
        int expected = 8;

        int length = progression.length();

        assertEquals(expected, length);
    }

    @Test
    void shouldCreateCorrectArrayRepresentation() {
        Integer[] expected = { 1, 6, 11, 16, 21, };
        Progression progression = new Progression(1, 25, 5);

        Integer[] actual = progression.toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    void equivalentInstancesShouldBeEqual() {
        Progression progression1 = new Progression(0, 10, 5);
        Progression progression2 = new Progression(0, 10, 5);

        assertTrue(progression1.equals(progression2));
    }

    @Test
    void nonEquivalentInstancesShouldBeUnequal() {
        Progression progression1 = new Progression(0, 10, 5);
        Progression progression2 = new Progression(0, 4, 2);

        assertFalse(progression1.equals(progression2));
    }

    @Test
    void equivalentInstancesShouldReturnSameHashCode() {
        Progression progression1 = new Progression(0, 10, 5);
        Progression progression2 = new Progression(0, 10, 5);

        assertEquals(progression1.hashCode(), progression2.hashCode());
    }

    @Test
    void nonEquivalentInstancesShouldReturnDifferentHashCode() {
        Progression progression1 = new Progression(0, 10, 5);
        Progression progression2 = new Progression(0, 4, 2);

        assertNotEquals(progression1.hashCode(), progression2.hashCode());
    }
}
