package xyz.rangefun;

import java.util.Objects;
import java.util.PrimitiveIterator;

public class RangeBuilder implements Iterable<Integer> {
    private int start;
    private int end;
    private int step;

    public RangeBuilder() {
        /* Suppresses default constructor. */
    }

    public RangeBuilder from(int start) {
        this.start = start;

        return this;
    }

    public RangeBuilder to(int end) {
        this.end = end;

        return this;
    }

    public RangeBuilder step(int step) {
        this.step = step;

        return this;
    }

    public RangeBuilder reverse() {
        int temp = start;
        start = end;
        end = temp;

        return this;
    }

    public Iterable<Integer> build() {
        return new RangeImpl(start, end, step);
    }

    @Override
    public PrimitiveIterator.OfInt iterator() {
        return (PrimitiveIterator.OfInt) build().iterator();
    }

    @Override
    public String toString() {
        return String.format("RangeBuilder{start=%s, end=%s, step=%s}",
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

        RangeBuilder other = (RangeBuilder) o;

        return start == other.start &&
                end == other.end &&
                step == other.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, step);
    }
}
