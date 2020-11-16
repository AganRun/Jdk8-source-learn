package test.classLoader.MyClassLoader;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("test.classLoader.MyClassLoader.MyClassLoader").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof test.classLoader.MyClassLoader.MyClassLoader);

        System.out.println("==============");

        Object obj2 = MyClassLoader.class.getClassLoader().loadClass("test.classLoader.MyClassLoader.MyClassLoader").newInstance();
        System.out.println(obj2);
        System.out.println(obj2 instanceof test.classLoader.MyClassLoader.MyClassLoader);
    }
}
