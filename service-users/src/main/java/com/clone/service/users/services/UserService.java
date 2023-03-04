package com.clone.service.users.services;

import com.clone.service.users.dtos.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(Long id);
}
