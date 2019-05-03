package com.vssekorin.tuplet;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public final class Tuple6<A, B, C, D, E, F> implements Tuple {

    private static final int SIZE = 6;

    private final A item1;
    private final B item2;
    private final C item3;
    private final D item4;
    private final E item5;
    private final F item6;

    public Tuple6(final A src1, final B src2, final C src3,
                  final D src4, final E src5, final F src6) {
        this.item1 = src1;
        this.item2 = src2;
        this.item3 = src3;
        this.item4 = src4;
        this.item5 = src5;
        this.item6 = src6;
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

    public E _5() {
        return this.item5;
    }

    public F _6() {
        return this.item6;
    }

    public Tuple5<B, C, D, E, F> removeFirst() {
        return new Tuple5<>(this.item2, this.item3, this.item4, this.item5, this.item6);
    }

    public Tuple5<A, B, C, D, E> removeLast() {
        return new Tuple5<>(this.item1, this.item2, this.item3, this.item4, this.item5);
    }

    public Tuple6<F, E, D, C, B, A> reverse() {
        return new Tuple6<>(this.item6, this.item5, this.item4, this.item3, this.item2, this.item1);
    }

    public <T> Tuple6<T, B, C, D, E, F> map_1(final Function<A, T> map) {
        return new Tuple6<>(
            map.apply(this.item1), this.item2, this.item3, this.item4, this.item5, this.item6
        );
    }

    public <T> Tuple6<A, T, C, D, E, F> map_2(final Function<B, T> map) {
        return new Tuple6<>(
            this.item1, map.apply(this.item2), this.item3, this.item4, this.item5, this.item6
        );
    }

    public <T> Tuple6<A, B, T, D, E, F> map_3(final Function<C, T> map) {
        return new Tuple6<>(
            this.item1, this.item2, map.apply(this.item3), this.item4, this.item5, this.item6
        );
    }

    public <T> Tuple6<A, B, C, T, E, F> map_4(final Function<D, T> map) {
        return new Tuple6<>(
            this.item1, this.item2, this.item3, map.apply(this.item4), this.item5, this.item6
        );
    }

    public <T> Tuple6<A, B, C, D, T, F> map_5(final Function<E, T> map) {
        return new Tuple6<>(
            this.item1, this.item2, this.item3, this.item4, map.apply(this.item5), this.item6
        );
    }

    public <T> Tuple6<A, B, C, D, E, T> map_6(final Function<F, T> map) {
        return new Tuple6<>(
            this.item1, this.item2, this.item3, this.item4, this.item5, map.apply(this.item6)
        );
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean contains(final Object obj) {
        return obj.equals(this.item1) || obj.equals(this.item2) || obj.equals(this.item3)
            || obj.equals(this.item4) || obj.equals(this.item5) || obj.equals(this.item6);
    }

    @Override
    public List<Object> toList() {
        return Arrays.asList(
            this.item1, this.item2, this.item3, this.item4, this.item5, this.item6
        );
    }

    @Override
    public String toString() {
        return "Tuple6(" +
            this.item1 + ", " + this.item2 + ", " + this.item3 + ", " +
            this.item4 + ", " + this.item5 + ", " + this.item6 + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Tuple6<?, ?, ?, ?, ?, ?> that = (Tuple6<?, ?, ?, ?, ?, ?>) obj;
        return Objects.equals(this.item1, that.item1) && Objects.equals(this.item2, that.item2)
            && Objects.equals(this.item3, that.item3) && Objects.equals(this.item4, that.item4)
            && Objects.equals(this.item5, that.item5) && Objects.equals(this.item6, that.item6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
    }
}
