import static_proxy.StaticCalculationImpl;
import static_proxy.StaticCalculationProxy;

public class ProxyDemoApplication {
    public static void main(String[] args) {
        var proxy = new StaticCalculationProxy(
                new StaticCalculationImpl()
        );
        System.out.println(
                proxy.add(1, 2)
        );
        System.out.println(
                proxy.subtract(3, 1)
        );
    }
}
