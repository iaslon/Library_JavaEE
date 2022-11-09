package com.company.lib.service.auth;

import com.company.lib.configs.ApplicationContextHolder;
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
import com.company.lib.utils.BaseUtils;

import java.util.Optional;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:51 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class UserServiceImpl extends AbstractDAO<UserDAO> implements UserService {

    private static UserServiceImpl userService;

    private final BaseUtils baseUtils = ApplicationContextHolder.getBean(BaseUtils.class);
    public UserServiceImpl() {
        super(ApplicationContextHolder.getBean(UserDAO.class));
    }

    public static UserServiceImpl getInstance() {
        if (userService==null){
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public UserDTO create(UserCreateDTO userCreateDTO) throws InvalidInputException {
        Optional<User> byEmail = dao.findByEmail(userCreateDTO.getEmail());
        if (byEmail.isPresent()) {
            throw new InvalidInputException("User by email %s already exists".formatted(byEmail.get()));
        }
        User user = User.builder()
                .email(userCreateDTO.getEmail())
                .name(userCreateDTO.getName())
                .password(baseUtils.encode(userCreateDTO.getPassword()))
                .surname(userCreateDTO.getSurname())
                .build();
        User savedUser = dao.save(user);
        return UserDTO.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .surname(savedUser.getSurname())
                .name(savedUser.getName())
                .build();
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
        String email = dto.getEmail();
        Optional<User> byEmail = dao.findByEmail(email);
        User user = byEmail.orElseThrow(() -> new InvalidInputException("user not found by email %s".formatted(email)));

        if (!baseUtils.matchPassword(dto.getPassword(),user.getPassword())){

            throw new AuthenticationException("Bad credentials");
        }
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .build();
    }

    @Override
    public UserDTO getByEmail(String email) throws NotFoundException {

        Optional<User> byEmail = dao.findByEmail(email);
        User user = byEmail.orElseThrow(() -> new NotFoundException("User not found by email"));



        return UserDTO.builder()
                .id(user.getId())
                .status(user.getStatus())
                .email(user.getEmail())
                .build();
    }
}
