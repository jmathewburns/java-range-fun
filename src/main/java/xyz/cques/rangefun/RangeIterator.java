package xyz.cques.rangefun;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;

/**
 * Created by Jacques on 2017/06/21.
 */
class RangeIterator implements PrimitiveIterator.OfInt {
    private final int end;
    private int current;

    RangeIterator(int start, int end) {
        this.current = start;
        this.end = end;
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
            return current++;
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
        return current <= end;
    }


}
