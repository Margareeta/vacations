package com.vacationsandusers.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class BaseDeletedEntity extends BaseEntity implements IDeletedEntity<Long> {
    @Column(name = "isDeleted")
    private boolean isDeleted;
}
