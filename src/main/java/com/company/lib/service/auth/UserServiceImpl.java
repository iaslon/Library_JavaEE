package com.company.lib.service.auth;

import com.company.lib.dao.AbstractDAO;
import com.company.lib.dao.UserDAO;
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
 * @since 11/09/2022 03:51 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class UserServiceImpl extends AbstractDAO<UserDAO> implements UserService {



    public UserServiceImpl(UserDAO dao) {
        super(ApplicaCon);
    }

    @Override
    public UserDTO create(UserCreateDTO userCreateDTO) throws InvalidInputException {
        return null;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(UserUpdateDTO dto) {

    }

    @Override
    public UserDTO login(UserLoginDTO dto) throws InvalidInputException, AuthenticationException {
        return null;
    }

    @Override
    public UserDTO getByEmail(String email) throws NotFoundException {
        return null;
    }
}
