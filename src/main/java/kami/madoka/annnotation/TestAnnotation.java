package kami.madoka.annnotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String value() default "888";
    String ccc() default  "666";
}
