package dev.Innocent.Section7.Generics;

@FunctionalInterface
public interface Operation<T> {
    T operate(T value1, T value2);
}
