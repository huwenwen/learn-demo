package com.wen.autoconfigure.bind;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.StandardEnvironment;

import java.lang.reflect.Field;

/**
 * @author huwenwen
 * @since 11/08/2018
 */
public class BindBeanUtils {

    public static <T> T bind(Class<T> clazz, StandardEnvironment environment) throws IllegalAccessException, InstantiationException {
        ConfigurationProperties annotation = AnnotationUtils.findAnnotation(clazz, ConfigurationProperties.class);
        if (annotation == null) {
            return null;
        }
        T result = clazz.newInstance();
        recursionBind(result, clazz, environment, annotation.prefix());
        return result;
    }

    private static <T> void recursionBind(T result, Class<?> clazz, StandardEnvironment environment, String prefix)
            throws IllegalAccessException, InstantiationException {
        if (isPrimitive(clazz)) {
            return;
        }
        for (Field field : clazz.getDeclaredFields()) {
            String key = prefix + "." + field.getName();
            String property = environment.getProperty(key);
            field.setAccessible(true);
            if (property != null) {
                field.set(result, property);
            }
            recursionBind(field.get(result), field.getType(), environment, key);
        }
    }

    private static boolean isPrimitive(Class clazz) {
        if (clazz.isPrimitive()) {
            return true;
        }
        return clazz.isAssignableFrom(CharSequence.class) || clazz.isAssignableFrom(Number.class) || clazz.isAssignableFrom(Boolean.class) || clazz
                .isAssignableFrom(Character.class);

    }
}
