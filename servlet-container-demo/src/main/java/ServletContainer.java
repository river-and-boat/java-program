import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class ServletContainer {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Class<?>> servletList = scanServletsInPath();
        System.out.println("在Container中线程执行到main方法啦: " + Thread.currentThread().getName());
        for (Class<?> clazz : servletList) {
            boolean hasMyWebServletAnnotation = clazz.isAnnotationPresent(MyWebServlet.class);
            boolean extendsHttpServlet = HttpServlet.class.isAssignableFrom(clazz);
            if (hasMyWebServletAnnotation && extendsHttpServlet) {
                HttpServlet servlet = (HttpServlet) clazz.getDeclaredConstructor().newInstance();
                servlet.init();
            }
        }
    }

    private static List<Class<?>> scanServletsInPath() {
        return Arrays.asList(BookServlet.class, OtherClass.class);
    }
}
