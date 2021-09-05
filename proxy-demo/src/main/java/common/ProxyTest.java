package common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        useClassObject();
        useClassProxy();
    }

    private static void useClassObject() {
        Class<Calculation> calculationClass = Calculation.class;
        Constructor<?>[] calculatorClazzConstructors = calculationClass.getConstructors();
        Method[] calculatorClazzMethods = calculationClass.getMethods();
        System.out.println("==================Class Constructors===============");
        printClassInfo(calculatorClazzConstructors);
        System.out.println("==================Class Methods===============");
        printClassInfo(calculatorClazzMethods);
    }

    private static void useClassProxy() {
        Class<?> calculatorProxyClazz = Proxy.getProxyClass(
                Calculation.class.getClassLoader(), Calculation.class
        );
        Constructor<?>[] constructors = calculatorProxyClazz.getConstructors();
        Method[] methods = calculatorProxyClazz.getMethods();
        System.out.println("==================Proxy Constructors===============");
        printClassInfo(constructors);
        System.out.println("==================Proxy Methods===============");
        printClassInfo(methods);
    }

    public static void printClassInfo(Executable[] targets) {
        for (Executable target : targets) {
            String name = target.getName();
            StringBuilder builder = new StringBuilder(name);
            builder.append("(");
            Class<?>[] clazzParams = target.getParameterTypes();
            for (Class<?> clazzParam : clazzParams) {
                builder.append(clazzParam.getName()).append(",");
            }
            if (clazzParams.length != 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(")");
            System.out.println(builder);
        }
    }


}
