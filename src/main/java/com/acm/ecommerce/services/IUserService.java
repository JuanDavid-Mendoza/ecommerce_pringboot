package com.acm.ecommerce.services;

import com.acm.ecommerce.models.UserModel;

import java.util.List;

public interface IUserService {
    public List<UserModel> getAllUsers();
    public UserModel getUserByUsername(String username);
}
