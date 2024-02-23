package com.hasith.restfulwebservicesforsocialmediaapplication.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static Integer id=0;

    static {
        users.add(new User(++id, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++id, "Eva", LocalDate.now().minusYears(30)));
        users.add(new User(++id, "Hasith", LocalDate.now().minusYears(23)));
        users.add(new User(++id, "Malshan", LocalDate.now().minusYears(23)));
    }

    public List<User> findAL() {
        return users;
    }

    public User findById(String id){
        return users.stream().filter(user -> user.getId()  ==  Integer.parseInt(id)).findFirst().orElse(null);
    }

}
