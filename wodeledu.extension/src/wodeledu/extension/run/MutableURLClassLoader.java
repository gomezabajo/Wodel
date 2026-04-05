package wodeledu.extension.run;

import java.net.URL;
import java.net.URLClassLoader;

public final class MutableURLClassLoader extends URLClassLoader {
    public MutableURLClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
    
    public void appendURL(URL url) {
        super.addURL(url);
    }
}
