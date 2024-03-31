package com.liferay.rk.rest.builder.client.function;

import javax.annotation.Generated;

/**
 * @author Ravi
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}