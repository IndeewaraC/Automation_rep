package com.automation.isq.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface VTAFRecoveryMethods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RecoveryMethods {

    /**
     * Recovery methods.
     * 
     */
    String [] recoveryMethods() default { };

    /**
     * Onerror methods.
     * 
     */
    String [] onerrorMethods() default { };
}
