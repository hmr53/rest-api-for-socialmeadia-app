package com.hasith.restfulwebservicesforsocialmediaapplication.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adan", LocalDate.now().minusYears(30)));
        users.add(new User(1, "Ewa", LocalDate.now().minusYears(30)));
        users.add(new User(1, "Hasith", LocalDate.now().minusYears(22)));
        users.add(new User(1, "Malshan", LocalDate.now().minusYears(22)));
    }

    public List<User> findAL() {
        return users;
    }

}
