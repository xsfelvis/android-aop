package com.app.annotation.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：xsf
 * @version: 2018/9/13
 * @Description:
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface CheckLogin {
}
