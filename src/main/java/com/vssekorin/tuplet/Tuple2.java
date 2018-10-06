package com.vssekorin.tuplet;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple2<A, B> {

    public final A _1;
    public final B _2;

    public Tuple2(final A src1, final B src2) {
        this._1 = src1;
        this._2 = src2;
    }

    public Tuple2<B, A> reverse() {
        return new Tuple2<>(this._2, this._1);
    }

    public <T> Tuple2<T, B> map_1(final Function<A, T> map) {
        return new Tuple2<>(map.apply(this._1), this._2);
    }

    public <T> Tuple2<A, T> map_2(final Function<B, T> map) {
        return new Tuple2<>(this._1, map.apply(this._2));
    }

    public boolean contains(final Object obj) {
        return obj.equals(this._1) || obj.equals(this._2);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this._1, this._2);
    }

    public Stream<Object> stream() {
        return Stream.of(this._1, this._2);
    }

    @Override
    public String toString() {
        return "Tuple2("
            + _1 + ", " + _2 + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) obj;
        if (_1 != null ? !_1.equals(tuple2._1) : tuple2._1 != null) return false;
        return _2 != null ? _2.equals(tuple2._2) : tuple2._2 == null;
    }

    @Override
    public int hashCode() {
        int result = _1 != null ? _1.hashCode() : 0;
        result = 31 * result + (_2 != null ? _2.hashCode() : 0);
        return result;
    }
}
