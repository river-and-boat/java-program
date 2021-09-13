public abstract class GenericServlet implements Servlet {
    @Override
    public void init() {
        System.out.println("线程执行到GenericServlet.init方法啦: " + Thread.currentThread().getName());
        System.out.println("如果子类不重写，那么你就会看到GenericServlet被调用");
        System.out.println("由" + this.getClass().getName() + "调用");
    }
}
