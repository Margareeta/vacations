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



}
