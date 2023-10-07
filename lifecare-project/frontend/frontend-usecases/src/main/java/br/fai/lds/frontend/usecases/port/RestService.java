package br.fai.lds.frontend.usecases.port;

import java.util.List;

public interface RestService <T> {

    List<T> get(final String resource);

    int post(final String resource, final T entity);

    boolean put(final String resource, final T entity);

    boolean delete(final String resource);

    T getById(final String resource, Class<T> clazz);

}