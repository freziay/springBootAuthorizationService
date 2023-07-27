package ru.netologe.repository;

import org.springframework.stereotype.Repository;
import ru.netologe.main.User;
import ru.netologe.authorities.Authorities;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<User, List<Authorities>> users = new ConcurrentHashMap<>();

    public UserRepository() {
        addUserAuthorities("Ivan", "password", Arrays.asList(Authorities.READ, Authorities.WRITE));
        addUserAuthorities("Alex", "password2", Arrays.asList(Authorities.READ, Authorities.WRITE));

    }

    public List<Authorities> getUserAuthorities(User user) {
        return users.get(user);
    }

    public void addUserAuthorities(String user, String password, List<Authorities> listAuthorities) {
        users.put(new User(user, password), listAuthorities);
    }

}