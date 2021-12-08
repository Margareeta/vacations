package com.vacationsandusers.model.base;

import java.io.Serializable;

public interface IEntity<I extends Serializable> {
    I getId();
}
