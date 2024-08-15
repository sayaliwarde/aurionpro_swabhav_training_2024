import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.db.CustomerDAO;
import com.aurionpro.entity.Customer;

@WebServlet("/customerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Customer customer = CustomerDAO.getCustomerByEmailAndPassword(email, password);
        if (customer != null) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("customerDashboard.jsp");
        } else {
            request.setAttribute("errorMessage", "User does not exist!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
