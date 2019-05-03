package com.vssekorin.tuplet;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public final class Tuple1<A> implements Tuple {

    private static final int SIZE = 1;

    private final A item1;

    public Tuple1(final A src) {
        this.item1 = src;
    }

    public A _1() {
        return this.item1;
    }

    public <T> Tuple2<T, A> addFirst(final T src) {
        return new Tuple2<>(src, this.item1);
    }

    public <T> Tuple2<A, T> addLast(final T src) {
        return new Tuple2<>(this.item1, src);
    }

    public Tuple0 removeFirst() {
        return new Tuple0();
    }

    public Tuple0 removeLast() {
        return new Tuple0();
    }

    public Tuple1<A> reverse() {
        return this;
    }

    public <T> Tuple1<T> map(final Function<A, T> map) {
        return new Tuple1<>(map.apply(this.item1));
    }

    public Optional<A> toOptional() {
        return Optional.ofNullable(this.item1);
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean contains(final Object obj) {
        return obj.equals(this.item1);
    }

    @Override
    public List<Object> toList() {
        return Collections.singletonList(this.item1);
    }

    @Override
    public String toString() {
        return "Tuple1(" + this.item1 + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Tuple1<?> that = (Tuple1<?>) obj;
        return Objects.equals(this.item1, that.item1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.item1);
    }
}
