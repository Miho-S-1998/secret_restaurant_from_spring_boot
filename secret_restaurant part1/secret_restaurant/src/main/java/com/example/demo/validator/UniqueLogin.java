package com.example.demo.validator;

	import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

	@Target({ElementType.METHOD,ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	@Constraint(validatedBy=UniqueLoginValidator.class)
	public @interface UniqueLogin {
		String message() default "この名前は既に登録されていますにゃ";
		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default{};

}

