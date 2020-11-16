package test.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("args:proxy-> " + proxy);
//        if (method.getName().equals("say")) {
            System.out.println("pre invoke");
            Object result = method.invoke(object, args);
            System.out.println("after invoke");
//        }
        return result;
    }
}
