package com.breakingbad;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    int num() default 0;
}
