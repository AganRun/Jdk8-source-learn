package test.reflect;

/**
 * hello的静态代理
 */
public class HelloStaticProxy implements Hello{

    private Hello hello;

    public HelloStaticProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Hello say(String words) {
        System.out.println("----代理前----");
        hello.say(words);
        System.out.println("----代理后----");
        return this;    //不能return hello,不然再次调用不会走代理
    }
}
