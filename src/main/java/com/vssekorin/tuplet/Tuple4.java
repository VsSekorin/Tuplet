package com.vssekorin.tuplet;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public final class Tuple4<A, B, C, D> implements Tuple {

    private static final int SIZE = 4;

    private final A item1;
    private final B item2;
    private final C item3;
    private final D item4;

    public Tuple4(final A src1, final B src2, final C src3, final D src4) {
        this.item1 = src1;
        this.item2 = src2;
        this.item3 = src3;
        this.item4 = src4;
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

    public D _4() {
        return this.item4;
    }

    public <T> Tuple5<T, A, B, C, D> addFirst(final T src) {
        return new Tuple5<>(src, this.item1, this.item2, this.item3, this.item4);
    }

    public <T> Tuple5<A, B, C, D, T> addLast(final T src) {
        return new Tuple5<>(this.item1, this.item2, this.item3, this.item4, src);
    }

    public Tuple3<B, C, D> removeFirst() {
        return new Tuple3<>(this.item2, this.item3, this.item4);
    }

    public Tuple3<A, B, C> removeLast() {
        return new Tuple3<>(this.item1, this.item2, this.item3);
    }

    public Tuple4<D, C, B, A> reverse() {
        return new Tuple4<>(this.item4, this.item3, this.item2, this.item1);
    }

    public <T> Tuple4<T, B, C, D> map_1(final Function<A, T> map) {
        return new Tuple4<>(map.apply(this.item1), this.item2, this.item3, this.item4);
    }

    public <T> Tuple4<A, T, C, D> map_2(final Function<B, T> map) {
        return new Tuple4<>(this.item1, map.apply(this.item2), this.item3, this.item4);
    }

    public <T> Tuple4<A, B, T, D> map_3(final Function<C, T> map) {
        return new Tuple4<>(this.item1, this.item2, map.apply(this.item3), this.item4);
    }

    public <T> Tuple4<A, B, C, T> map_4(final Function<D, T> map) {
        return new Tuple4<>(this.item1, this.item2, this.item3, map.apply(this.item4));
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean contains(final Object obj) {
        return obj.equals(this.item1) || obj.equals(this.item2) || obj.equals(this.item3)
            || obj.equals(this.item4);
    }

    @Override
    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2, this.item3, this.item4);
    }

    @Override
    public String toString() {
        return "Tuple4(" +
            this.item1 + ", " + this.item2 + ", " + this.item3 + ", " +
            this.item4 + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Tuple4<?, ?, ?, ?> that = (Tuple4<?, ?, ?, ?>) obj;
        return Objects.equals(this.item1, that.item1) && Objects.equals(this.item2, that.item2)
            && Objects.equals(this.item3, that.item3) && Objects.equals(this.item4, that.item4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.item1, this.item2, this.item3, this.item4);
    }
}
