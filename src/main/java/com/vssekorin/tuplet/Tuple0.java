package com.vssekorin.tuplet;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class Tuple0 implements Tuple {

    private static final int SIZE = 0;

    public Tuple0() {
    }

    public <T> Tuple1<T> addFirst(final T src) {
        return new Tuple1<>(src);
    }

    public <T> Tuple1<T> addLast(final T src) {
        return new Tuple1<>(src);
    }

    public Tuple0 reverse() {
        return this;
    }

    public Optional<Object> toOptional() {
        return Optional.empty();
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean contains(final Object obj) {
        return false;
    }

    @Override
    public List<Object> toList() {
        return Collections.emptyList();
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
