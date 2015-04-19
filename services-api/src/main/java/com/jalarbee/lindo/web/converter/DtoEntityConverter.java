package com.jalarbee.lindo.web.converter;

/**
 * @author Abdoulaye Diallo
 */
public interface DtoEntityConverter<D, E> {

    E convert(D dto);
}
