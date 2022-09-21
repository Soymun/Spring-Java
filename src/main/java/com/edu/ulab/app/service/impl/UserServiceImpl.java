package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.exception.NotFoundException;
import com.edu.ulab.app.mapper.dto.UserDtoMapper;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final Storage storage;

    private final UserDtoMapper userDtoMapper;

    @Autowired
    public UserServiceImpl(Storage storage, UserDtoMapper userDtoMapper) {
        this.storage = storage;
        this.userDtoMapper = userDtoMapper;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userDtoMapper.userDtoToUser(userDto);
        log.info("Create user: {}", user);
        return userDtoMapper.userToUserDto(storage.saveUser(user));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userDtoMapper.userDtoToUser(userDto);
        log.info("Update user: {}", user);
        return userDtoMapper.userToUserDto(storage.updateUser(user));
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = storage.getUser(id);
        if(user == null){
            throw  new NotFoundException(String.format("User with id:%d not found", id));
        }
        log.info("Get user: {}", user);
        return userDtoMapper.userToUserDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        log.info("Delete user with id: {}", id);
        storage.deleteUser(id);
    }
}
