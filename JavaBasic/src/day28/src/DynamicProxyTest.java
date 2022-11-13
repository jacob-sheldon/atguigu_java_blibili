import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Util {
    public static void method1() {
        System.out.println("=======调用方法一=========");
    }
    public static void method2() {
        System.out.println("=======调用方法二=========");
    }
}

class MyInvocationHandler implements InvocationHandler {
    Object obj; // 被代理类对象

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Util.method1();
        Object invoke = method.invoke(obj, args);
        Util.method2();
        return invoke;
    }
}

/**
 * 动态代理工厂
 */
class DynamicProxy {
    public static Object generateDynamicProxy(Object obj) {
        InvocationHandler invoc = new MyInvocationHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invoc);
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory o = (ClothFactory) DynamicProxy.generateDynamicProxy(nikeFactory);
        o.produceCloths();
    }
}