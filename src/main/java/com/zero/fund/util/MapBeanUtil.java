package com.zero.fund.util;

import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;


public class MapBeanUtil {
    private static final Logger log = getLogger(MapBeanUtil.class);

    private MapBeanUtil() {
    }

    /**
     * 合并两个数组
     *
     * @param a
     * @param b
     * @return
     */
    public static Method[] mergeMethod(Method[] a, Method[] b) {
        int total = a.length + b.length;
        Method[] temp = new Method[total];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            temp[i + a.length] = b[i];
        }
        return temp;
    }

    /**
     * 合并两个数组
     *
     * @param a
     * @param b
     * @return
     */
    public static Field[] mergeField(Field[] a, Field[] b) {
        int total = a.length + b.length;
        Field[] temp = new Field[total];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            temp[i + a.length] = b[i];
        }
        return temp;
    }

    /**
     * 返回Map Field
     *
     * @param a
     * @param b
     * @return
     */
    public static Map<String, Field> mergeMapField(Field[] a, Field[] b) {
        Field[] fields = mergeField(a, b);
        Map<String, Field> result = new HashMap<>(256);

        for (Field f : fields) {
            result.put(f.getName(), f);
        }
        return result;
    }

    /**
     * 将bean转换为map。 key值全部转为小写
     *
     * @param o
     * @return
     */
    public static Map bean2Map(Object o) {
        Method[] methods = mergeMethod(o.getClass().getDeclaredMethods(), o.getClass().getSuperclass().getDeclaredMethods());
        Map<String, Field> field = mergeMapField(o.getClass().getDeclaredFields(), o.getClass().getSuperclass().getDeclaredFields());
        Map oMap = new HashMap(methods.length * 4 / 3);
        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i].getName();
            if (methodName.startsWith("get") && !"getClass".equals(methodName)) {
                String fieldName = methodName.substring(3);
                if (field.containsKey(fieldName)) {
                    try {
                        Object value = methods[i].invoke(o);
                        if (Objects.equals(null, value)) {
                            oMap.put(fieldName, "");
                        } else {
                            oMap.put(fieldName, value);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        log.error("bean2Map error: {}", e);
                        continue;
                    }
                }

            }
        }
        return oMap;
    }

    /**
     * 将List<bean>的结构转为 Map<String,String>[]</>
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Map<String, ?>[] beanList2MapArray(List<T> list) {
        log.debug("MapBeanUtil.beanList2MapArray size:{}", list.size());
        List<Map<String, ?>> res = new ArrayList();
        Map<String, ?>[] desc = new Map[list.size()];
        for (T app : list) {
            if (app instanceof Map) {
                res.add((Map<String, ?>) app);
            } else {
                res.add(bean2Map(app));
            }

        }
        return res.toArray(desc);
    }


}