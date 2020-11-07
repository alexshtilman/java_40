package telran.validation;

import java.util.*;

import telran.validation.constrains.Email;
import telran.validation.constrains.Future;
import telran.validation.constrains.Max;
import telran.validation.constrains.Min;
import telran.validation.constrains.NotEmpty;
import telran.validation.constrains.NotNull;
import telran.validation.constrains.Past;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.time.LocalDate;

public class Validator {

	public static List<String> validate(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		List<String> result = new ArrayList<>();
		for (Field field : fields) {
			field.setAccessible(true);
			for (Annotation annotation : field.getAnnotations()) {
				processAnnotation(result, obj, annotation, field);
			}
		}

		return result;
	}

	@SuppressWarnings("unused")
	private static void NotNull(List<String> result, Object obj, Field field, Annotation annotation) {
		NotNull a = (NotNull) annotation;
		try {
			if (field.get(obj) == null) {
				result.add(a.msg());
			}
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static void Min(List<String> result, Object obj, Field field, Annotation annotation) {
		Min a = (Min) annotation;
		try {
			if (field.getInt(obj) < a.value()) {
				result.add(a.msg());
			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static void Future(List<String> result, Object obj, Field field, Annotation annotation) {
		Future a = (Future) annotation;
		try {
			LocalDate fieldDateTime = (LocalDate) field.get(obj);
			if (fieldDateTime.isBefore(LocalDate.now())) {
				result.add(a.msg());
			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static void Past(List<String> result, Object obj, Field field, Annotation annotation) {
		Past a = (Past) annotation;
		try {
			LocalDate fieldDateTime = (LocalDate) field.get(obj);
			if (fieldDateTime.isAfter(LocalDate.now())) {
				result.add(a.msg());
			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static void Max(List<String> result, Object obj, Field field, Annotation annotation) {
		Max a = (Max) annotation;
		try {
			if (field.getInt(obj) > a.value()) {
				result.add(a.msg());
			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static void NotEmpty(List<String> result, Object obj, Field field, Annotation annotation) {
		NotEmpty a = (NotEmpty) annotation;
		try {
			String notEmpty = (String) field.get(obj);
			if (notEmpty.isEmpty()) {
				result.add(a.msg());
			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static void Email(List<String> result, Object obj, Field field, Annotation annotation) {
		Email a = (Email) annotation;
		try {
			String email = (String) field.get(obj);
			if (!email.matches(a.regexp())) {
				result.add(a.msg());
			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static void Valid(List<String> result, Object obj, Field field, Annotation annotation) {
		try {
			Object objV = field.get(obj);
			Field[] fields = objV.getClass().getDeclaredFields();
			for (Field fieldV : fields) {
				fieldV.setAccessible(true);
				for (Annotation annotationV : fieldV.getAnnotations()) {
					processAnnotation(result, objV, annotationV, fieldV);
				}
			}
		} catch (Exception e) {
		}
	}

	private static void processAnnotation(List<String> result, Object obj, Annotation annotation, Field field) {
		try {
			Class<?> clazz = Class.forName("telran.validation.Validator");
			String className = annotation.annotationType().getSimpleName();
			Method method = clazz.getDeclaredMethod(className, List.class, Object.class, Field.class, Annotation.class);
			method.invoke(clazz, result, obj, field, annotation);
		} catch (Exception e1) {
		}
	}
}
