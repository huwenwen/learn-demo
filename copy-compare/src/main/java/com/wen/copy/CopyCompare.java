package com.wen.copy;

import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author huwenwen
 * @since 15/01/2019
 */
public class CopyCompare {

    @SneakyThrows
    public static DestBean apache(SourceBean sourceBean) {
        DestBean dest = new DestBean();
        BeanUtils.copyProperties(dest, sourceBean);
        return dest;
    }

    public static DestBean spring(SourceBean sourceBean) {
        DestBean dest = new DestBean();
        org.springframework.beans.BeanUtils.copyProperties(sourceBean, dest, "class");
        return dest;
    }

    public static DestBean cglib(SourceBean sourceBean) {
        DestBean dest = new DestBean();
        BeanCopier copier = BeanCopier.create(SourceBean.class, DestBean.class, false);
        copier.copy(sourceBean, dest, null);
        return dest;
    }

    public static DestBean cglibX(SourceBean sourceBean) {
        DestBean dest = new DestBean();
        BeanCopierX.copyProperties(sourceBean, dest);
        return dest;
    }

    public static DestBean setter(SourceBean sourceBean) {
        if (sourceBean == null) {
            return null;
        }
        DestBean dest = new DestBean();
        dest.setC1(sourceBean.getC1());
//        dest.setC2(sourceBean.getC2());
//        dest.setC3(sourceBean.getC3());
//        dest.setC4(sourceBean.getC4());
//        dest.setC5(sourceBean.getC5());
//        dest.setC6(sourceBean.getC6());
//        dest.setC7(sourceBean.getC7());
//        dest.setC8(sourceBean.getC8());
//        dest.setC9(sourceBean.getC9());
//        dest.setC10(sourceBean.getC10());
//        dest.setC11(sourceBean.getC11());
//        dest.setC12(sourceBean.getC12());
//        dest.setC13(sourceBean.getC13());
//        dest.setC14(sourceBean.getC14());
//        dest.setC15(sourceBean.getC15());
        return dest;
    }

}
