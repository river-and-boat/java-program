package static_proxy;

import common.Calculation;

public class StaticCalculationImpl implements Calculation {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        int result = a - b;
        return result;
    }
}
