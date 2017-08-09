package xyz.cques.rangefun;

import java.util.Iterator;

/**
 * Created by Jacques on 2017/06/20.
 */
public class RangeTestHelper {
    private RangeTestHelper() {
        throw new AssertionError(
                "RangeTestHelper is not instantiable"
        );
    }

    /**
     * Tests if the given {@code Iterable} returns no more and no less than all of the integers
     * in {@code expectedInts}, in order.
     *
     * @param range     The Iterable to be tested.
     * @param expectedInts The integers that should be returned by {@code interval}.
     * @return {@code true} if {@code interval} is the same size as {@code expectedInts} and
     * returns the values of {@code expectedInts}, in order, {@code false} otherwise.
     */
    static boolean rangeReturnsExpectedInts(Iterable<Integer> range, int[] expectedInts) {
        Iterator<Integer> rangeIterator = range.iterator();
        return rangeReturnsExpectedInts(rangeIterator, expectedInts);
    }

    static boolean rangeReturnsExpectedInts(Iterator<Integer> rangeIterator, int[] expectedInts) {
        int currentIndex = 0;
        int rangeSize = 0;

        while (rangeIterator.hasNext()) {
            int current = rangeIterator.next();

            if (!intAtIndexEqualsExpected(expectedInts, currentIndex, current)) {
                return false;
            }

            rangeSize++;
            currentIndex++;
        }

        return rangeSize == expectedInts.length;
    }

    private static boolean intAtIndexEqualsExpected(int[] array, int index, int expected) {
        if (index < 0 || index >= array.length) {
            return false;
        }

        return array[index] == expected;
    }
}
