package telran.validation.constrains;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/*
 * 
 */
public @interface NotNull {
	String msg() default "❌ field can't be null";
}
