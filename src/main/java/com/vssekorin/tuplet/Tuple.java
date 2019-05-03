package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public interface Tuple extends Serializable, Iterable<Object> {

    int size();

    boolean contains(final Object obj);

    List<Object> toList();

    default Object[] toArray() {
        return this.toList().toArray();
    }

    default Stream<Object> stream() {
        return this.toList().stream();
    }

    @Override
    default Iterator<Object> iterator() {
        return this.toList().iterator();
    }
}
