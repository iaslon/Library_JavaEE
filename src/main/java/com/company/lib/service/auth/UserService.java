package com.company.lib.service.auth;

import com.company.lib.domains.User;
import com.company.lib.dto.auth.UserCreateDTO;
import com.company.lib.dto.auth.UserDTO;
import com.company.lib.dto.auth.UserLoginDTO;
import com.company.lib.dto.auth.UserUpdateDTO;
import com.company.lib.exceptions.AuthenticationException;
import com.company.lib.exceptions.InvalidInputException;
import com.company.lib.exceptions.NotFoundException;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:37 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public interface UserService {


    UserDTO create(UserCreateDTO userCreateDTO) throws InvalidInputException;

    User get(long id);

    void delete(long id);

    void update(UserUpdateDTO dto);

    UserDTO login(UserLoginDTO dto) throws InvalidInputException, AuthenticationException;

    UserDTO getByEmail(String email) throws NotFoundException;

}
