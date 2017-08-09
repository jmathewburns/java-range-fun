package xyz.rangefun;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;

class SimpleRangeIterator implements PrimitiveIterator.OfInt {
    private final int step;
    private final int end;
    private int current;

    SimpleRangeIterator(int start, int end, int step) {
        this.current = start;
        this.end = end;
        this.step = step;
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
        return current <= end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleRangeIterator other = (SimpleRangeIterator) o;

        return  step == other.step &&
                end == other.end &&
                current == other.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step,
                            end,
                            current);
    }

    @Override
    public String toString() {
        return String.format(
                "SimpleRangeIterator{step=%s, end=%s, current=%s}",
                step, end, current
        );
    }
}
