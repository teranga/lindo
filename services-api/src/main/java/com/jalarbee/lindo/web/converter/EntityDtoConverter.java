package com.jalarbee.lindo.web.converter;

import com.jalarbee.lindo.domain.Organization;

/**
 * @author Abdoulaye Diallo
 */
public interface EntityDtoConverter<E, D> {

    D convert(E entity);
}
