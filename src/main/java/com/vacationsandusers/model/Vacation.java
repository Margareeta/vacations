package com.vacationsandusers.model;

import com.vacationsandusers.model.base.BaseDeletedEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString(exclude = {"user",  "id"})
@EqualsAndHashCode
@Entity
@Table(name = "vacation")
public class Vacation extends BaseDeletedEntity {
    @Column(name = "date_from")
    private LocalDate dateFrom;
    @Column(name = "date_to")
    private LocalDate dateTo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; //proxy object

    public Vacation(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Vacation(LocalDate dateFrom, LocalDate dateTo, User user) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.user = user;
    }
}
