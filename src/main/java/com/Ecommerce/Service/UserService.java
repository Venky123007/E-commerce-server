package com.Ecommerce.Service;

import com.Ecommerce.Exception.UserException;
import com.Ecommerce.model.User;
import jdk.jshell.spi.ExecutionControl;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}
