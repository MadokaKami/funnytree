package kami.madoka.main;

import kami.madoka.annnotation.TestAnnotation;
import kami.madoka.beanfactory.TestFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * @Description
 * @ClassName Main
 * @Date 2018/4/27 16:31
 * @Author 李英夫
 * @version V1.0.0
 * @Copyright (c) All Rights Reserved, 2018/4/27.
 */
public class Main {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestFactoryBean.class);
        factory.registerBeanDefinition("abc",rootBeanDefinition);
        System.out.println(factory.getBean("abc"));
        System.out.println(factory.getBean("&abc"));
        System.out.println(Arrays.toString(factory.getBeanNamesForAnnotation(TestAnnotation.class)));
        System.out.println(factory.findAnnotationOnBean("abc", TestAnnotation.class));
    }
}
