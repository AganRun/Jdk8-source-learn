package test.reflect;

public class HelloImpl implements Hello{

    @Override
    public Hello say(String words) {
        System.out.println("我是正经的Hello实现, args:" + words);
        return this;
    }
}
