package se.deved;

import java.util.function.Function;

public class MyOptional<T> {

    private T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public static <K> MyOptional<K> of(K value) {
        return new MyOptional<>(value);
    }

    public static <K> MyOptional<K> empty() {
        return new MyOptional<>(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T get() {
        if (isEmpty())
            throw new NullPointerException("Value is null");

        return value;
    }

    public T orElse(T other) {
        if (isEmpty()) return other;
        return value;
    }

    public <K> MyOptional<K> map(Function<T, K> mapper) {
        if (isEmpty()) return MyOptional.empty();
        return MyOptional.of(mapper.apply(value));
    }
}
