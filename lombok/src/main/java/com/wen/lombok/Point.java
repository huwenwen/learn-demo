package com.wen.lombok;

import lombok.Value;

/**
 * @author huwenwen
 * @since 15/09/2018
 */
@Value(staticConstructor = "of")
public class Point {
    private double x;
    private double y;

    public static void main(String[] args) {
        FluentBean fluentBean = new FluentBean();
    }
}
