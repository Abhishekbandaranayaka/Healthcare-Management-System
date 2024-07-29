package com.healthcare_app.api_gateway.mappers;

import com.healthcare_app.api_gateway.dto.SignUpDto;
import com.healthcare_app.api_gateway.dto.UserDto;
import com.healthcare_app.api_gateway.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password" , ignore = true)
    User signUpToUser(SignUpDto userDto);
}
