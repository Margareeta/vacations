package com.vacationsandusers.model.base;

import java.io.Serializable;

public interface IDeletedEntity<T extends Serializable> extends IEntity <T>{
    boolean isDeleted();
    void setDeleted(boolean isDeleted);
}
