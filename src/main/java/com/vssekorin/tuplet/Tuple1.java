package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple1<A> implements Serializable {

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

    public Tuple1<A> reverse() {
        return this;
    }

    public <T> Tuple1<T> map(final Function<A, T> map) {
        return new Tuple1<>(map.apply(this.item1));
    }

    public boolean contains(final Object obj) {
        return obj.equals(this.item1);
    }

    public Optional<A> toOptional() {
        return Optional.ofNullable(this.item1);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<A> toList() {
        return Collections.singletonList(this.item1);
    }

    public Stream<A> stream() {
        return Stream.of(this.item1);
    }

    @Override
    public String toString() {
        return "Tuple1(" + item1 + ")";
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
        return item1 != null ? item1.equals(tuple1.item1) : tuple1.item1 == null;
    }

    @Override
    public int hashCode() {
        return item1 != null ? item1.hashCode() : 0;
    }
}
