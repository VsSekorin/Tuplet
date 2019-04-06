package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class Tuple0<A> implements Serializable {

    public Tuple0() {
    }

    public <T> Tuple1<T> addFirst(final T src) {
        return new Tuple1<>(src);
    }

    public <T> Tuple1<T> addLast(final T src) {
        return new Tuple1<>(src);
    }

    public Tuple0<A> reverse() {
        return this;
    }

    public boolean contains(final Object obj) {
        return false;
    }

    public Optional<A> toOptional() {
        return Optional.empty();
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public List<A> toList() {
        return Collections.emptyList();
    }

    public Stream<A> stream() {
        return Stream.empty();
    }

    @Override
    public String toString() {
        return "Tuple0";
    }

    @Override
    public boolean equals(final Object obj) {
        return this == obj || obj instanceof Tuple0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
