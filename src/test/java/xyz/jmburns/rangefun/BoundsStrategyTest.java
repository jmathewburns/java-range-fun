package xyz.jmburns.rangefun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundsStrategyTest {
    @Test
    void higherValueShouldCrossUpperBounds() {
        shouldCross(BoundsStrategy.UPPER, 5, 3);
    }

    @Test
    void equalValueShouldNotCrossUpperBounds() {
        shouldNotCross(BoundsStrategy.UPPER, 4, 4);
    }

    @Test
    void lowerValueShouldNotCrossUpperBounds() {
        shouldNotCross(BoundsStrategy.UPPER, 2, 6);
    }

    @Test
    void higherValueShouldNotCrossLowerBounds() {
        shouldNotCross(BoundsStrategy.LOWER, 10, 5);
    }

    @Test
    void equalValueShouldNotCrossLowerBounds() {
        shouldNotCross(BoundsStrategy.LOWER, 2, 2);
    }

    @Test
    void lowerValueShouldCrossLowerBounds() {
        shouldCross(BoundsStrategy.LOWER, 7, 13);
    }

    private void shouldCross(BoundsStrategy bounds, int value, int boundary) {
        assertTrue(bounds.crossed(value, boundary));
    }

    private void shouldNotCross(BoundsStrategy bounds, int value, int boundary) {
        assertFalse(bounds.crossed(value, boundary));
    }
}