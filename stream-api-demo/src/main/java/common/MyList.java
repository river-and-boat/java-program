package common;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    private final List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

    public boolean add(T t) {
        return list.add(t);
    }

    public MyList<T> filter(MyPredicate<T> predicate) {
        MyList<T> filteredList = new MyList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    public <R> MyList<R> map(MyFunction<T, R> mapper) {
        MyList<R> mappedList = new MyList<>();
        for (T t : list) {
            mappedList.add(mapper.apply(t));
        }
        return mappedList;
    }
}
