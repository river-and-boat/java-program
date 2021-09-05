package static_proxy;

import common.Calculation;

public class StaticCalculationProxy implements Calculation {
    private final Calculation calculation;

    public StaticCalculationProxy(Calculation calculation) {
        this.calculation = calculation;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("Before Action");
        int result = calculation.add(a, b);
        System.out.println("After Action");
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("Before Action");
        int result = calculation.subtract(a, b);
        System.out.println("After Action");
        return result;
    }
}
