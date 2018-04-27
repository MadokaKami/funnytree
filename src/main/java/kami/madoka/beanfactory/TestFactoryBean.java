package kami.madoka.beanfactory;

import kami.madoka.annnotation.TestAnnotation;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Controller;

@Controller
@TestAnnotation
public class TestFactoryBean implements FactoryBean<String> {

    public String getObject() throws Exception {
        return "123456789";
    }

    public Class<?> getObjectType() {
        return String.class;
    }

    public boolean isSingleton() {
        return false;
    }

    @Override
    public String toString() {
        return "this bean is TestFactoryBean";
    }
}
