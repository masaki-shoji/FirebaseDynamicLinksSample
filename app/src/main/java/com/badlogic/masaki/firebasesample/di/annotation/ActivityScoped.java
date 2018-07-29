package com.badlogic.masaki.firebasesample.di.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;
import java.lang.annotation.RetentionPolicy;

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {

}
