package wodel.ai.assistant.utils;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface QuadriFunction<T, U, V, R, S> {
	S apply(T t, U u, V v, R r);
	
	default <K> QuadriFunction<T, U, V, R, K> andThen(Function<? super S, ? extends K> after) {
		Objects.requireNonNull(after);
		return (T t, U u, V v, R r) -> after.apply(apply(t, u, v, r));
	}
}
