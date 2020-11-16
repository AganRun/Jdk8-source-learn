package test.reflect;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                new MyInvocationHandler(new HelloImpl()));
        hello.say("A").say("B").say("C");
    }
}
