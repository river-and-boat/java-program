package common;

@FunctionalInterface
public interface MyFunction<E, R> {
    R apply(E e);
}
