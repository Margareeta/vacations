package com.vacationsandusers.model.base;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@SuperBuilder
@NoArgsConstructor
@QueryEntity
@MappedSuperclass
public abstract class BaseEntity implements IEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date created")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "date updated")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
