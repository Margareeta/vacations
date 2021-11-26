package com.vacationsandusers.model;
import com.vacationsandusers.model.base.BaseDeletedEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
// override equals and hashcode

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(exclude = "id")
@Entity
@Table(name = "users")
public class User extends BaseDeletedEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)//mappedBy
    private List<Vacation> usersVacations;//persistent bag implements list, can connect to a session*,
    // is also a proxy

}