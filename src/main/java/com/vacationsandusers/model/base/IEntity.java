package com.vacationsandusers.model.base;

import java.io.Serializable;

public interface IEntity<T extends Serializable> {
    T getId();
}
