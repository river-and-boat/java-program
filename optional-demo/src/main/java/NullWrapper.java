import java.util.Objects;
import java.util.function.Function;

public final class NullWrapper<T> {
    private static final NullWrapper<?> EMPTY = new NullWrapper<>();

    // actual value
    private final T value;

    private NullWrapper() {
        this.value = null;
    }

    private NullWrapper(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <E> NullWrapper<E> ofNullable(E value) {
        return value == null ? empty() : of(value);
    }

    public static <E> NullWrapper<E> empty() {
        @SuppressWarnings("unchecked")
        NullWrapper<E> wrapper = (NullWrapper<E>) EMPTY;
        return wrapper;
    }

    public static <E> NullWrapper<E> of(E value) {
        return new NullWrapper<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public <U> NullWrapper<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return NullWrapper.ofNullable(mapper.apply(value));
        }
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }
}
