package xyz.cques.rangefun;

import java.util.Iterator;

/**
 * Created by Jacques on 2017/06/20.
 */
public class RangeTestHelper {
    private RangeTestHelper() {
        throw new AssertionError();
    }

    /**
     * Tests if the given {@code Interval} returns no more and no less than all of the integers
     * in {@code expectedInts}, in order.
     *
     * @param interval     The Interval to be tested.
     * @param expectedInts The integers that should be returned by {@code interval}.
     * @return {@code true} if {@code interval} is the same size as {@code expectedInts} and
     * returns the values of {@code expectedInts}, in order, {@code false} otherwise.
     */
    public static boolean rangeReturnsExpectedInts(Interval interval, int[] expectedInts) {
        Iterator<Integer> rangeIterator = interval.iterator();
        return rangeReturnsExpectedInts(rangeIterator, expectedInts);
    }

    public static boolean rangeReturnsExpectedInts(Iterator<Integer> rangeIterator, int[] expectedInts) {
        int currentIndex = 0;
        int rangeSize = 0;

        while (rangeIterator.hasNext()) {
            int current = rangeIterator.next();

            int expected;
            try {
                expected = expectedInts[currentIndex];
            } catch (ArrayIndexOutOfBoundsException exception) {
                return false;
            }

            if (current != expected) {
                return false;
            }

            rangeSize++;
            currentIndex++;
        }

        return rangeSize == expectedInts.length;
    }
}
