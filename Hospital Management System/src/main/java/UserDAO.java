package src.main.java;


import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<>();

    // Save a user to the list
    public void save(User user) {
        users.add(user);
    }

    // Retrieve all users
    public List<User> findAll() {
        return users;
    }
}
