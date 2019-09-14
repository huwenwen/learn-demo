package com.wen.autoconfigure.pylon;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author huwenwen
 * @since 11/08/2018
 */
public class ClientPostProcessor implements BeanFactoryPostProcessor, EnvironmentAware {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getBeanDefinitionNames());
    }

    public void setEnvironment(Environment environment) {
        System.out.println(environment);
    }
}
