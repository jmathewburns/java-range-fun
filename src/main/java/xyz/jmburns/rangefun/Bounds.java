package xyz.jmburns.rangefun;

enum Bounds {
    LOWER {
        @Override
        boolean crossed(int value, int boundary) {
            return value < boundary;
        }
    },
    UPPER {
        @Override
        boolean crossed(int value, int boundary) {
            return value > boundary;
        }
    };

    abstract boolean crossed(int value, int boundary);
}