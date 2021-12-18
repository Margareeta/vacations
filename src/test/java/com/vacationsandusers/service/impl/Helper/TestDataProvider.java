package com.vacationsandusers.service.impl.Helper;

import com.vacationsandusers.model.User;
import com.vacationsandusers.model.Vacation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TestDataProvider {
    public User buildFullUser(int number) {
        User user1 = User.builder()
                .firstName("Katya" + number)
                .lastName("Petrova" + number)
                .email("3@mail.com" + number)
                .build();
        user1.setUsersVacations(List.of(
                new Vacation(LocalDate.of(2020, 05, 03),
                        LocalDate.of(2020, 06, 03), user1),

                new Vacation(LocalDate.of(2021, 03, 03),
                        LocalDate.of(2021, 04, 04), user1)));
        return user1;
    }

    public User buildUser(int number) {
        User user2 = User.builder()
                .firstName("Olya" + number)
                .lastName("Ivanova" + number)
                .email("4@mail.com" + number)
                .build();
        return user2;
    }


}
