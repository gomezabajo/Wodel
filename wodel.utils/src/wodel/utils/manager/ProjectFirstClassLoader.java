package wodel.utils.manager;

import java.net.URL;
import java.net.URLClassLoader;

public final class ProjectFirstClassLoader
        extends URLClassLoader {

    ProjectFirstClassLoader(
            URL[] urls,
            ClassLoader parent) {

        super(urls, parent);
    }

    @Override
    protected Class<?> loadClass(
            String name,
            boolean resolve)
            throws ClassNotFoundException {

        synchronized (getClassLoadingLock(name)) {

            Class<?> loaded =
                findLoadedClass(name);

            if (loaded == null) {

                /*
                 * Generated Wodel classes should come
                 * from the target Wodel project first.
                 */
                if (name.startsWith("mutator.")) {

                    try {
                        loaded =
                            findClass(name);
                    }
                    catch (ClassNotFoundException ignored) {
                        // Fall back to parent below.
                    }
                }

                /*
                 * EMF, Wodel runtime, JDK classes, etc.
                 * should normally come from the parent.
                 */
                if (loaded == null) {
                    loaded =
                        super.loadClass(
                            name,
                            false);
                }
            }

            if (resolve) {
                resolveClass(loaded);
            }

            return loaded;
        }
    }
}