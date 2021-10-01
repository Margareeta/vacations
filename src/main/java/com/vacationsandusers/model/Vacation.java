package com.vacationsandusers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name =  "vacation")
public class Vacation {
    @Id
    @GeneratedValue
    @Column(name = "date_from")
    private String dateFrom;
    @Column(name = "date_to")
    private String dateTo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}