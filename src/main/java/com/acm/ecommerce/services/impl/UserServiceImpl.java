package com.acm.ecommerce.services.impl;

import com.acm.ecommerce.dto.UserDto;
import com.acm.ecommerce.models.UserModel;
import com.acm.ecommerce.services.IUserService;
import com.acm.ecommerce.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final RestTemplate restTemplate;

    @Override
    public List<UserModel> getAllUsers() {
        UserDto[] users = restTemplate.getForObject("/users", UserDto[].class);
        if (users == null || users.length == 0) { return List.of(); }
        return UserMapper.dtoListToModelList(List.of(users));
    }

    @Override
    public UserModel getUserByUsername(String username) {
        List<UserModel> users = this.getAllUsers();
        return users
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst().orElse(null);
    }
}
