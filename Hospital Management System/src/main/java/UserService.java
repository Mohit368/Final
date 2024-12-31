package src.main.java;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    // Constructor
    public UserService() {
        this.userDAO = new UserDAO(); // Initialize the DAO
    }

    // Add a new user
    public void addUser(User user) {
        userDAO.save(user);
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
