package demo;

import demo.annotation.MyAfter;
import demo.annotation.MyBefore;
import demo.annotation.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJUnitFrameWork {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<EmployeeServiceTest> clazz = EmployeeServiceTest.class;
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getMethods();

        List<Method> myBeforeMethods = new ArrayList<>();
        List<Method> myAfterMethods = new ArrayList<>();
        List<Method> myTests = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                myBeforeMethods.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                myTests.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                myAfterMethods.add(method);
            }
        }

        for (Method testMethod : myTests) {
            for (Method beforeMethod : myBeforeMethods) {
                beforeMethod.invoke(obj);
            }
            testMethod.invoke(obj);
            for (Method afterMethod : myAfterMethods) {
                afterMethod.invoke(obj);
            }
        }
    }
}
