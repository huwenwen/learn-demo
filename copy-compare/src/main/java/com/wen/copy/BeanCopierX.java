package com.wen.copy;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huwenwen
 * @since 15/01/2019
 */
public class BeanCopierX {

    private static final int MAX_CACHE_SIZE = 500;

    private static Map<String, BeanCopier> beanCopierCache = new ConcurrentHashMap<>();

    protected static void copyProperties(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target, null);
    }

    private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!beanCopierCache.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            if (beanCopierCache.size() > MAX_CACHE_SIZE) {
                beanCopierCache.clear();
            }
            beanCopierCache.put(beanKey, copier);
        } else {
            copier = beanCopierCache.get(beanKey);
        }
        return copier;
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.getName() + class2.getName();
    }

}
