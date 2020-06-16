package main.application.utils;

public interface Validator<T> {

	public boolean validate(T t);
}
