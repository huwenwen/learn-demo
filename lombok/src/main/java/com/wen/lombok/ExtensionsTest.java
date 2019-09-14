package com.wen.lombok;

import lombok.experimental.ExtensionMethod;

import java.util.Arrays;

/**
 * @author huwenwen
 * @since 15/09/2018
 */
@ExtensionMethod({ Arrays.class, Extensions.class })
public class ExtensionsTest {

    public String test() {
        String str = null;
        Extensions.or(str, "hello");
        return str;
    }

    public static void main(String[] args) {

    }
}
