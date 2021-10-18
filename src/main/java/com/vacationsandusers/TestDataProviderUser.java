package com.vacationsandusers;

import com.vacationsandusers.model.User;
import com.vacationsandusers.model.Vacation;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@NoArgsConstructor
public class TestDataProviderUser {
    public User build(){
        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setEmail("3@mail.com");
        Vacation vacation = new Vacation();
        vacation.setDateFrom("01.01.2020");
        vacation.setDateTo("01.02.2020");
        vacation.setUser(user);
        Vacation vacation1 = new Vacation();
        vacation.setDateFrom("03.01.2020");
        vacation.setDateTo("03.02.2020");
        vacation.setUser(user);
        List<Vacation> vacationList= new ArrayList<>();
        vacationList.add(vacation1);
        vacationList.add(vacation);
        user.setUsersVacations(vacationList);

        return user;
    }
}
