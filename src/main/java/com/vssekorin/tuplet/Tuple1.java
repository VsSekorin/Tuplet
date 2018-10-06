package com.vssekorin.tuplet;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class Tuple1<A> {

    public final A _1;

    public Tuple1(final A src) {
        this._1 = src;
    }

    public <B> Tuple2<A, B> add(final B src) {
        return new Tuple2<>(this._1, src);
    }

    public Tuple1<A> reverse() {
        return this;
    }

    public boolean contains(final Object obj) {
        return obj.equals(this._1);
    }

    public Optional<A> toOptional() {
        return Optional.ofNullable(this._1);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<A> toList() {
        return Collections.singletonList(this._1);
    }

    public Stream<A> toStream() {
        return Stream.of(this._1);
    }

    @Override
    public String toString() {
        return "Tuple1(" + _1 + ")";
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
        return _1 != null ? _1.equals(tuple1._1) : tuple1._1 == null;
    }

    @Override
    public int hashCode() {
        return _1 != null ? _1.hashCode() : 0;
    }
}
