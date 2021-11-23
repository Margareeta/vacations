package com.vacationsandusers.controller;

import com.vacationsandusers.converter.Converter;
import com.vacationsandusers.generated.dto.UserDto;
import com.vacationsandusers.model.User;
import com.vacationsandusers.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//сделать все методы с дто ----

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor // for final fields only
public class UserController {
    private final IUserService service;
    private final Converter converter;

    @GetMapping("/users")
    public List <User> list() {
        return service.list();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
        // /api/v1/users/1
    }

    //из дто сделать модель, отправить ее в сервис и превратить ее в дто
    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = converter.fromDto(userDto);
        user = service.create(user);
        return converter.toDto(user);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto,
                              @PathVariable(name = "id") Long id){
        User user = converter.fromDto(userDto);
        user = service.update(user, id);
        return converter.toDto(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(name ="id") Long id){
        service.delete(id);
    }

    @DeleteMapping("/users")
    public void deleteAll(){
        service.deleteAll();
    }
}
