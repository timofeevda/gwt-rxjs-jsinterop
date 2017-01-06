package org.timofeevda.gwt.rxjs.interop.functions;

/**
 *
 * @author dtimofeev since 06.01.2017.
 * 
 * @param <T>
 * @param <R>
 */
public interface ProjectWithArray<T,R> {
    R call(T v, T...args);
}
