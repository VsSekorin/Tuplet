package com.vssekorin.tuplet;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class Tuple1<A> {

    private final A item;

    public Tuple1(final A src) {
        this.item = src;
    }

    public A _1() {
        return this.item;
    }

    public boolean contains(final Object obj) {
        return obj.equals(this.item);
    }

    public Optional<A> toOptional() {
        return Optional.ofNullable(this.item);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<A> toList() {
        return Collections.singletonList(this.item);
    }

    public Stream<A> toStream() {
        return Stream.of(this.item);
    }

    @Override
    public String toString() {
        return "Tuple1(" + item + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Tuple1<?> tuple1 = (Tuple1<?>) obj;
        return item != null ? item.equals(tuple1.item) : tuple1.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}
