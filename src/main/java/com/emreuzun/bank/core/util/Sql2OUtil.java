package com.emreuzun.bank.core.util;

import com.emreuzun.bank.core.annotation.Column;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Sql2OUtil {

    public static Map<String, String> getColumnMapping(Object object) {
        Map<String, String> colMaps = new HashMap<String, String>();
        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Annotation[] annotations = f.getDeclaredAnnotations();
            if (annotations != null) {
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getName().equals(Column.class.getName())) {
                        Column column = (Column) annotation;
                        colMaps.put(column.name(), f.getName());
                    }
                }
            }
        }
        return colMaps;
    }

}
