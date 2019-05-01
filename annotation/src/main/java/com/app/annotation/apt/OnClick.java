package com.app.annotation.apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：xsf
 * @version: 2018/9/17
 * @Description:
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnClick {
    int[] value();
}
