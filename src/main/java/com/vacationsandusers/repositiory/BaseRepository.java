package com.vacationsandusers.repositiory;

import com.vacationsandusers.model.base.IEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends IEntity<I>, I extends Serializable> extends
        JpaRepository <T,I>, QuerydslPredicateExecutor<T>{

}
