package wodel.utils.manager;

import java.util.Objects;
import java.util.random.RandomGenerator;

public final class WodelRandomContext {

    private static final ThreadLocal<RandomGenerator> CURRENT =
        new ThreadLocal<>();


    private WodelRandomContext() {
    }


    public static void set(
            RandomGenerator random) {

        CURRENT.set(
            Objects.requireNonNull(
                random,
                "random"));
    }


    public static RandomGenerator current() {

        RandomGenerator random =
            CURRENT.get();

        if (random == null) {

            throw new IllegalStateException(
                "No Wodel random generator is bound "
                + "to the current execution thread");
        }

        return random;
    }


    /**
     * Compatibility helper for Wodel code that can also execute outside
     * an explicit deterministic execution context.
     */
    public static RandomGenerator currentOrDefault() {

        RandomGenerator random =
            CURRENT.get();

        if (random != null) {

            return random;
        }

        return ModelManager.rn;
    }


    public static boolean isBound() {

        return CURRENT.get() != null;
    }


    public static void clear() {

        CURRENT.remove();
    }
}