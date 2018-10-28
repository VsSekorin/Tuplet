package com.vssekorin.tuplet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FP {
    private FP() {
    }

    public static <A, B> List<Tuple2<A, B>> zip(final Iterable<A> first, final Iterable<B> second) {
        final List<Tuple2<A, B>> result = new ArrayList<>();
        final Iterator<A> firstIter = first.iterator();
        final Iterator<B> secondIter = second.iterator();
        while (firstIter.hasNext() && secondIter.hasNext()) {
            result.add(new Tuple2<>(firstIter.next(), secondIter.next()));
        }
        return result;
    }
}
