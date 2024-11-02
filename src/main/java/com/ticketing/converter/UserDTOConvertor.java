package com.ticketing.converter;

import com.ticketing.dto.UserDTO;
import com.ticketing.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConvertor implements Converter<String,UserDTO> {

    private final UserService userService;

    public UserDTOConvertor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
