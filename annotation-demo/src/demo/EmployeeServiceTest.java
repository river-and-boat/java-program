package demo;

import demo.annotation.MyAfter;
import demo.annotation.MyBefore;
import demo.annotation.MyTest;

public class EmployeeServiceTest {
    @MyBefore
    public void init() {
        System.out.println("初始化测试资源");
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁测试资源");
    }

    @MyTest
    public void testSave() {
        System.out.println("测试保存功能");
    }

    @MyTest
    public void testDelete() {
        System.out.println("测试删除功能");
    }
}
