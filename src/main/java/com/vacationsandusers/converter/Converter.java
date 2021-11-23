package com.vacationsandusers.converter;


import com.vacationsandusers.generated.dto.UserDto;
import com.vacationsandusers.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Converter {
    @Qualifier("standardModelMapper")
    private ModelMapper mapper;

    public UserDto toDto(User user){
        return mapper.map(user, UserDto.class);
    }

    public User fromDto(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        user.getUsersVacations().forEach(vacation -> vacation.setUser(user));
        return user;
    }
}
