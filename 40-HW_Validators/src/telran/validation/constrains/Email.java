package telran.validation.constrains;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Email {
String regexp() default "[^\\s,]+@[\\w^_]+(\\.[\\w^-_][\\w-]+){1,3}";
String msg() default "❌ not valid email format";
}
