package com.hospital;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet annotation for mapping
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Temporary in-memory storage for users
    private static List<User> users = new ArrayList<>();

    /**
     * Handles GET requests to display user data.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add users to the request attribute for display
        request.setAttribute("users", users);

        // Forward the request to display.jsp
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    /**
     * Handles POST requests for user registration.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get form parameters
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String email = request.getParameter("email");

            // Validate inputs
            if (name == null || name.isEmpty() || age == null || email == null || email.isEmpty()) {
                request.setAttribute("error", "All fields are required.");
                request.getRequestDispatcher("form.jsp").forward(request, response);
                return;
            }

            int ageInt = Integer.parseInt(age);

            // Create a new User object and add it to the list
            User user = new User(name, ageInt, email);
            users.add(user);

            // Redirect to the register endpoint to show updated data
            response.sendRedirect("register");
        } catch (NumberFormatException e) {
            // Handle invalid age input
            request.setAttribute("error", "Age must be a valid number.");
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
    }
}
