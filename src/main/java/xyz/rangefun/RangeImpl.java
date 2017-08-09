package xyz.rangefun;

import java.util.Objects;
import java.util.PrimitiveIterator;

/**
 * Created by Jacques on 08-08-2017.
 */
final class RangeImpl implements Iterable<Integer> {
    private final int start;
    private final int end;
    private final int step;
    private final boolean backwards;

    RangeImpl(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;

        backwards = (start > end || step < 0);
    }

    /**
     * Returns an iterator over elements of type {@code Integer}.
     *
     * @return an Iterator.
     */
    @Override
    public PrimitiveIterator.OfInt iterator() {
        if (backwards) {
            return new ReverseRangeIterator(start, end, step);
        }
        return new SimpleRangeIterator(start, end, step);
    }

    @Override
    public String toString() {
        return String.format("RangeImpl{start=%s, end=%s, step=%s}",
                             start, end, step);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RangeImpl other = (RangeImpl) o;

        return start == other.start &&
                end == other.end &&
                step == other.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, step);
    }
}