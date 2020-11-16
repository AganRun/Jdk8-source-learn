package test.reflect;

public class Test {

    public static void main(String[] args) {
        Hello hello = new HelloStaticProxy(new HelloImpl());
        hello.say("A").say("B").say("C");
    }
}
