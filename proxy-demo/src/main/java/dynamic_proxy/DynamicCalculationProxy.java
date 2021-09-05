package dynamic_proxy;

import common.Calculation;
import static_proxy.StaticCalculationImpl;

import java.lang.reflect.*;

public class DynamicCalculationProxy {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        StaticCalculationImpl calculationImpl = new StaticCalculationImpl();

        Calculation calculation = (Calculation) Proxy.newProxyInstance(
                calculationImpl.getClass().getClassLoader(),
                calculationImpl.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    System.out.println(method.getName() + " method is ready to be executed");
                    Object result = method.invoke(calculationImpl, args1);
                    System.out.println(method.getName() + " method has finished");
                    return result;
                }
        );
        System.out.println(calculation.add(1, 2));
    }
}
