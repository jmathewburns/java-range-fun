package xyz.cques.rangefun;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;

/**
 * Created by Jacques on 2017/06/20.
 */
public class Range {
    public static Interval of(int low, int high) {
        return (() -> new RangeIterator(low, high));
    }

    private static class RangeIterator implements PrimitiveIterator.OfInt {
        private final int end;
        private int current;

        RangeIterator(int start, int end) {
            this.current = start;
            this.end = end;
        }

        /**
         * Returns the next {@code int} element in the iteration.
         *
         * @return the next {@code int} element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public int nextInt() {
            return current++;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current <= end;
        }


    }
}
