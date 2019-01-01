package com.vssekorin.tuplet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Tuple {

    private Tuple() {
    }

    public static <A, B> Tuple2<A, B> from(final Map.Entry<A, B> entry) {
        return new Tuple2<>(entry.getKey(), entry.getValue());
    }

    public static <A, B> List<Tuple2<A, B>> from(final Map<A, B> map) {
        return map.entrySet().stream().map(Tuple::from).collect(Collectors.toList());
    }
}
