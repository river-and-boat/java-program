package dao;

import annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class BaseDao<T> {
    private Class<T> beanClass;

    public BaseDao() {
        beanClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void add(T bean) {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        StringBuilder sql = new StringBuilder()
                .append("insert into ")
                .append(beanClass.getAnnotation(Table.class).value())
                .append(" value(");
        for (int i = 0; i < declaredFields.length; i++) {
            sql.append("?");
            if (i < declaredFields.length - 1) {
                sql.append(",");
            }
            sql.append(")");

            ArrayList<Object> paramList = new ArrayList<>();
            try {
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(bean);
                    paramList.add(obj);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            sql.append(paramList);
            System.out.println(sql);
        }
    }
}
