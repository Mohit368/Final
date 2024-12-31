# Final
<br>
Explanation of the Code
Create and Configure Servlets:

The RegisterServlet handles HTTP requests. It maps to the /register URL, as specified by the @WebServlet annotation.
Implement doGet and doPost Methods:

The doGet method forwards user data to a JSP page for display.
The doPost method collects data from a registration form and stores it in a List of User objects.
Implement User Form Registration and Profile:

The form.jsp page contains an HTML form where users input their data. This data is sent to the servlet for processing.
Integrate JSP with Servlets:

Data collected in the servlet (doGet method) is sent to display.jsp for rendering using request.setAttribute.
Implement JSP Pages for Displaying User Data:

The display.jsp page dynamically shows user data in a table format. The data is fetched from the request scope.
Use JSTL and EL in JSP Pages:

JSTL (<c:forEach>) and EL (${user.name}) are used in display.jsp to iterate over the user list and display their properties.
