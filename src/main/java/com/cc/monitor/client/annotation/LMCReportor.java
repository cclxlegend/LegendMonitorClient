package com.cc.monitor.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LMCReportor {

    /**
     * 自定义上报任务名称
     * @return
     */
    public String name();
    /**
     * 调度周期,默认5s上报一次
     * @return
     */
    public int interval() default 5;

    /**
     * 延时调度,默认0
     * @return
     */
    public int lazyFire() default 0;

}
