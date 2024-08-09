package com.healthcare_app.api_gateway.mappers;

import com.healthcare_app.api_gateway.dto.SignUpDto;
import com.healthcare_app.api_gateway.dto.UserDto;
import com.healthcare_app.api_gateway.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for converting between User entity and various DTOs.
 * Utilizes MapStruct for generating mapping implementations at compile time.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Maps a User entity to a UserDto.
     *
     * @param user The User entity to map.
     * @return The mapped UserDto.
     */
    UserDto toUserDto(User user);

    /**
     * Maps a SignUpDto to a User entity.
     * The password field is ignored during mapping to prevent overwriting.
     *
     * @param signUpDto The SignUpDto to map.
     * @return The mapped User entity.
     */
    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
