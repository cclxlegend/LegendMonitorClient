package com.cc.monitor.client.annotation;


import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface QuotaParameter {

    public boolean rejectIfNull() default false;

    public String name() default StringUtils.EMPTY;
}
