package com.wen.lombok;

import lombok.experimental.UtilityClass;

/**
 * @author huwenwen
 * @since 15/09/2018
 */
@UtilityClass
public class Extensions {

    public static <T> T or(T object, T ifNull) {
        return object != null ? object : ifNull;
    }

}
