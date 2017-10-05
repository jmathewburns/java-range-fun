package xyz.jmburns.rangefun;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

class ProgressionIterator implements Iterator<Integer>, Comparable<ProgressionIterator> {
    private final Bounds bounds;
    private final int step;
    private final int end;
    private int current;

    private ProgressionIterator(int start, int end, int step, Bounds bounds) {
        this.bounds = bounds;
        this.current = start;
        this.step = step;
        this.end = end;
    }

    static ProgressionIterator ascending(int start, int end, int step) {
        //invariants: end >= start, step > 0
        return new ProgressionIterator(start, end, step, Bounds.UPPER);
    }

    static ProgressionIterator descending(int start, int end, int step) {
        //invariants: end <= start, step > 0
        return new ProgressionIterator(start, end, -step, Bounds.LOWER);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int old = current;
            current = current + step;
            return old;
        } else {
            throw new NoSuchElementException(
                    "the end of the progression has been reached"
            );
        }
    }

    @Override
    public boolean hasNext() {
        return !bounds.crossed(current, end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressionIterator other = (ProgressionIterator) o;
        return step == other.step &&
               end == other.end &&
               current == other.current &&
               bounds == other.bounds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bounds, step, end, current);
    }

    @Override
    public String toString() {
        return String.format(
                "ProgressionIterator{bounds=%s, step=%s, end=%s, current=%s}",
                bounds, step, end, current
        );
    }

    @Override
    public int compareTo(ProgressionIterator other) {
        if (this == other) return 0;
        int result =  bounds.compareTo(other.bounds);
        if (result == 0) { result = Integer.compare(step, other.step); }
        if (result == 0) { result = Integer.compare(end, other.end); }
        if (result == 0) { result = Integer.compare(current, other.current); }
        return result;
    }
}
