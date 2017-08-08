package xyz.cques.rangefun;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;

/**
 * Created by Jacques on 2017/06/21.
 */
class RangeIterator implements PrimitiveIterator.OfInt {
    private boolean backwardsIteration;
    private final int step;
    private final int end;
    private int current;

    RangeIterator(int start, int end, int step) {
        this.current = start;
        this.end = end;

        if (isBackwardsIteration(start, end)) {
            backwardsIteration = true;
            this.step = negative(step);
        } else {
            this.step = step;
        }
    }

    private boolean isBackwardsIteration(int start, int end) {
        return start > end;
    }

    private int negative(int number) {
        int newNumber = number;

        if (newNumber > 0) {
            newNumber = -newNumber;
        }

        return newNumber;
    }

    /**
     * Returns the next {@code int} element in the range.
     *
     * @return the next {@code int} element in the range
     * @throws NoSuchElementException if the end of the range has been reached
     */
    @Override
    public int nextInt() {
        if (hasNext()) {
            int oldCurrent = current;
            current = current + step;
            return oldCurrent;
        } else {
            throw new NoSuchElementException(
                    "the end of the range has been reached"
            );
        }
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
        if (backwardsIteration) {
            return current >= end;
        }
        return current <= end;
    }
}
