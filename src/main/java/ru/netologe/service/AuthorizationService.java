package ru.netologe.service;

import ru.netologe.authorities.Authorities;
import ru.netologe.exception.InvalidCredentials;
import ru.netologe.exception.UnauthorizedUser;
import ru.netologe.main.User;
import ru.netologe.repository.UserRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {



    UserRepository userRepository;
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) throws InvalidCredentials, UnauthorizedUser {
        if (isEmpty(user.getUserName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUserName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}