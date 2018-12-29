package com.vssekorin.tuplet;

import java.util.Map;

public final class Tuple {

    private Tuple() {
    }

    public static <A, B> Tuple2<A, B> from(final Map.Entry<A, B> entry) {
        return new Tuple2<>(entry.getKey(), entry.getValue());
    }
}
