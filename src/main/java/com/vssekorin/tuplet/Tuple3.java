package com.vssekorin.tuplet;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public final class Tuple3<A, B, C> implements Tuple {

    private static final int SIZE = 3;

    private final A item1;
    private final B item2;
    private final C item3;

    public Tuple3(final A src1, final B src2, final C src3) {
        this.item1 = src1;
        this.item2 = src2;
        this.item3 = src3;
    }

    public A _1() {
        return this.item1;
    }

    public B _2() {
        return this.item2;
    }

    public C _3() {
        return this.item3;
    }

    public <T> Tuple4<T, A, B, C> addFirst(final T src) {
        return new Tuple4<>(src, this.item1, this.item2, this.item3);
    }

    public <T> Tuple4<A, B, C, T> addLast(final T src) {
        return new Tuple4<>(this.item1, this.item2, this.item3, src);
    }

    public Tuple2<B, C> removeFirst() {
        return new Tuple2<>(this.item2, this.item3);
    }

    public Tuple2<A, B> removeLast() {
        return new Tuple2<>(this.item1, this.item2);
    }

    public Tuple3<C, B, A> reverse() {
        return new Tuple3<>(this.item3, this.item2, this.item1);
    }

    public <T> Tuple3<T, B, C> map_1(final Function<A, T> map) {
        return new Tuple3<>(map.apply(this.item1), this.item2, this.item3);
    }

    public <T> Tuple3<A, T, C> map_2(final Function<B, T> map) {
        return new Tuple3<>(this.item1, map.apply(this.item2), this.item3);
    }

    public <T> Tuple3<A, B, T> map_3(final Function<C, T> map) {
        return new Tuple3<>(this.item1, this.item2, map.apply(this.item3));
    }

    @Override
    public int size() {
        return SIZE;
    }

    public boolean contains(final Object obj) {
        return obj.equals(this.item1) || obj.equals(this.item2) || obj.equals(this.item3);
    }

    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2, this.item3);
    }

    @Override
    public String toString() {
        return "Tuple3(" + this.item1 + ", " + this.item2 + ", " + this.item3 +")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Tuple3<?, ?, ?> that = (Tuple3<?, ?, ?>) obj;
        return Objects.equals(this.item1, that.item1) && Objects.equals(this.item2, that.item2)
            && Objects.equals(this.item3, that.item3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.item1, this.item2, this.item3);
    }
}
