package com.pi.util;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtil {


    /**
     * 把map转为java bean
     *
     * @param map
     * @param clazz
     * @return
     */
    public static <T> T fromMap(Map<String, Object> map, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())
                        || field.isSynthetic()) {
                    // 静态变量、synthetic和父类对象变量性忽略
                    continue;
                }
                // boolean类型
                if (field.getType().getName().equals("boolean")) {
                    field.setBoolean(t, Boolean.valueOf((String) map.get(field.getName())));
                } else if (field.getType().getName().equals("java.lang.Integer")) {
                    if (null != map.get((field.getName()))) {
                        field.setInt(t, Integer.parseInt(String.valueOf(map.get(field.getName()))));
                    }
                } else if (field.getType().getName().equals("java.lang.Long")) {
                    if (null != map.get((field.getName()))) {
                        field.setLong(t, Long.parseLong(String.valueOf(map.get(field.getName()))));
                    }
                } else { // 其他类型
                    if (null != map.get((field.getName()))) {
                        field.set(t, map.get(field.getName()));
                    }
                }
            }
        } catch (Exception ex) {

            throw new RuntimeException("", ex);
        }
        return t;
    }

    /**
     * 把javabean 转成 map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> toMap(Object obj) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            for (Field field : obj.getClass().getDeclaredFields()) {
                handleAccessible(field);
                if (null != field.get(obj)) {
                    map.put(field.getName(), field.get(obj));
                }
            }
            return map;
        } catch (Exception ex) {

            throw new RuntimeException("", ex);
        }

    }

    public static <T> Map<String, T> toMap(Object obj, Class<T> t) {
        try {
            Map<String, T> map = new HashMap<String,  T>();
            for (Field field : obj.getClass().getDeclaredFields()) {
                handleAccessible(field);
                if (null != field.get(obj)) {
                    map.put(field.getName(), (T) field.get(obj));
                }
            }
            return map;
        } catch (Exception ex) {

            throw new RuntimeException("", ex);
        }
    }

    public static Map<String, String> toStringMap(Object obj) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            for (Field field : obj.getClass().getDeclaredFields()) {
                handleAccessible(field);
                if (null != field.get(obj)) {
                    map.put(field.getName(), String.valueOf(field.get(obj)));
                }
            }
            return map;
        } catch (Exception ex) {

            throw new RuntimeException("", ex);
        }
    }

    /**
     * 是否需要忽略权限检查
     *
     * @param field
     */
    private static void handleAccessible(Field field) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
    }
}
