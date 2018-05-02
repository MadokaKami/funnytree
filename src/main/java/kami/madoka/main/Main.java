package kami.madoka.main;

import kami.madoka.annnotation.TestAnnotation;
import kami.madoka.beanfactory.TestFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

import java.util.Arrays;
import java.util.Set;

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
        //--------------------------------------------beanfactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestFactoryBean.class);
        factory.registerBeanDefinition("abc",rootBeanDefinition);
        System.out.println(factory.getBean("abc"));
        System.out.println(factory.getBean("&abc"));
        System.out.println(Arrays.toString(factory.getBeanNamesForAnnotation(TestAnnotation.class)));
        System.out.println(factory.findAnnotationOnBean("abc", TestAnnotation.class));
        //----------------------------------------BeanDefinitionRegistry
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        BeanDefinition beanDefinitionGeneric = new GenericBeanDefinition();
        BeanDefinition beanDefinitionRoot = new RootBeanDefinition();
        registry.registerBeanDefinition("b1",beanDefinitionGeneric);
        registry.registerBeanDefinition("b2",beanDefinitionRoot);
        System.out.println(registry.containsBeanDefinition("b2"));
        System.out.println(registry.getBeanDefinitionCount());
        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));
        //-------------------------------------propertiesBeandefinitionReader
        PropertiesBeanDefinitionReader porpertiesReader = new PropertiesBeanDefinitionReader(registry);
        porpertiesReader.loadBeanDefinitions("my-ini.properties");
        System.out.println(registry.getBeanDefinitionCount());
        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));
        //-------annotatedBean
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(registry);
        //构造方法中AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry);添加了对注解的支持
        annotatedBeanDefinitionReader.register(TestAnnotation.class);
        System.out.println(registry.getBeanDefinitionCount());
        ClassPathScanningCandidateComponentProvider privider = new ClassPathScanningCandidateComponentProvider(true);
        Set<BeanDefinition> definitionSet = privider.findCandidateComponents("kami.madoka.entity");
        System.out.println(definitionSet.size());
        //ClassPathBeanDefinitionScanner
        //ListableBeanFactory HierarchicalBeanFactory AutowireCapableBeanFactory ConfigurableBeanFactory ConfigurableListableBeanFactory AbstractBeanFactory
        //AbstractAutowireCapableBeanFactory  DefaultListableBeanFactory
    }
}
