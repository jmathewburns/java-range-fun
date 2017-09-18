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

import java.util.Iterator;

class ProgressionTestHelper {
    static boolean progressionReturnsOnlyExpectedIntegers(Progression progression, int[] expectedInts) {
        Iterator<Integer> iterator = progression.iterator();
        return iteratorReturnsOnlyExpectedIntegers(iterator, expectedInts);
    }

    static boolean iteratorReturnsOnlyExpectedIntegers(Iterator<Integer> iterator, int[] expectedInts) {
        int currentIndex = 0;
        int rangeSize = 0;

        while (iterator.hasNext()) {
            int currentInteger = iterator.next();

            if (!intAtIndexIsExpected(expectedInts, currentIndex, currentInteger)) {
                return false;
            }

            rangeSize++;
            currentIndex++;
        }

        return rangeSize == expectedInts.length;
    }

    private static boolean intAtIndexIsExpected(int[] array, int index, int expected) {
        return indexIsInRange(array, index) && array[index] == expected;
    }

    private static boolean indexIsInRange(int[] array, int index) {
        return (0 <= index && index < array.length);
    }
}
