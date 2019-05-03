package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple2<A, B> implements Serializable {

    private final A item1;
    private final B item2;

    public Tuple2(final A src1, final B src2) {
        this.item1 = src1;
        this.item2 = src2;
    }

    public A _1() {
        return this.item1;
    }

    public B _2() {
        return this.item2;
    }

    public <T> Tuple3<T, A, B> addFirst(final T src) {
        return new Tuple3<>(src, item1, item2);
    }

    public <T> Tuple3<A, B, T> addLast(final T src) {
        return new Tuple3<>(item1, item2, src);
    }

    public Tuple1<B> removeFirst() {
        return new Tuple1<>(item2);
    }

    public Tuple1<A> removeLast() {
        return new Tuple1<>(item1);
    }

    public Tuple2<B, A> reverse() {
        return new Tuple2<>(this.item2, this.item1);
    }

    public <T> Tuple2<T, B> map_1(final Function<A, T> map) {
        return new Tuple2<>(map.apply(this.item1), this.item2);
    }

    public <T> Tuple2<A, T> map_2(final Function<B, T> map) {
        return new Tuple2<>(this.item1, map.apply(this.item2));
    }

    public boolean contains(final Object obj) {
        return obj.equals(this.item1) || obj.equals(this.item2);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2);
    }

    public Stream<Object> stream() {
        return Stream.of(this.item1, this.item2);
    }

    @Override
    public String toString() {
        return "Tuple2(" + item1 + ", " + item2 + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Tuple2<?, ?> that = (Tuple2<?, ?>) obj;
        return Objects.equals(item1, that.item1) && Objects.equals(item2, that.item2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item1, item2);
    }
}
