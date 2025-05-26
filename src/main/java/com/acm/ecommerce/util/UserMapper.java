package com.acm.ecommerce.util;

import com.acm.ecommerce.dto.UserDto;
import com.acm.ecommerce.models.UserModel;

import java.util.List;

public class UserMapper {
    public static UserDto modelToDto(UserModel user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .phone(user.getPhone())
                .build();
        userDto.setName(user.getFirstName(), user.getLastName());
        return userDto;
    }

    public static UserModel dtoToModel(UserDto user) {
        return UserModel.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .phone(user.getPhone())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public static List<UserDto> modelListToDtoList(List<UserModel> users) {
        return users.stream().map(UserMapper::modelToDto).toList();
    }

    public static List<UserModel> dtoListToModelList(List<UserDto> users) {
        return users.stream().map(UserMapper::dtoToModel).toList();
    }
}
