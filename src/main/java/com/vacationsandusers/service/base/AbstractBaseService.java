package com.vacationsandusers.service.base;

import com.querydsl.core.types.Predicate;
import com.vacationsandusers.model.base.IEntity;
import com.vacationsandusers.repositiory.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseService
        <T extends IEntity<I>, I extends Serializable, R extends BaseRepository<T, I>>
        implements BaseService<T, I> {

    public abstract R getRepository();

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public Optional<T> get(I id) {
        return getRepository().findById(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public Optional<T> get(Predicate predicate) {
        return getRepository().findOne(predicate);
    }

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public Page<T> findAll(Predicate predicate, Pageable pageable) {
        return getRepository().findAll(predicate, pageable);
    }

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void delete(T t) {
        getRepository().delete(t);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(I id) {
        getRepository().deleteById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public boolean isExistent(I id) {
        return getRepository().existsById(id);
    }
}
