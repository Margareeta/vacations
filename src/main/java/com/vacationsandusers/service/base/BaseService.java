package com.vacationsandusers.service.base;

import com.querydsl.core.types.Predicate;
import com.vacationsandusers.model.base.IEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends IEntity<I>, I extends Serializable> {
    Optional<T> get(I id);

    Optional<T> get(Predicate predicate);

    Page<T> findAll(Predicate predicate, Pageable pageable);

    List<T> findAll();

    T save(T t);

    void delete(T t);

    void delete(I id);

    boolean isExistent(I id);

}
