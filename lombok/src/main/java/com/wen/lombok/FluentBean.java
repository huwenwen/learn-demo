package com.wen.lombok;

import com.wen.autoconfigure.Foo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author huwenwen
 * @since 15/09/2018
 */
@Data
@Accessors(chain = true)
public class FluentBean {

    private String name;
    private Integer age;
    private BigDecimal price;
    private String foo = Foo.getValue();
}
