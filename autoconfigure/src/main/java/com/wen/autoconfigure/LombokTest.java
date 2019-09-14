package com.wen.autoconfigure;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author huwenwen
 * @since 15/09/2018
 */
@Data
@Accessors(chain = true)
public class LombokTest {

    @Setter
    @Accessors(chain = true)
    @Getter
    private String str;

}
