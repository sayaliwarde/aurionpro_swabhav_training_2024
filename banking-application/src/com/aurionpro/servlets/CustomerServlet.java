package com.aurionpro.servlets;

import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.dao.TransactionDAO;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "newTransaction":
                newTransaction(request, response);
                break;
            case "editProfile":
                editProfile(request, response);
                break;
            default:
                response.sendRedirect("customer_home.jsp");
                break;
        }
    }

    private void newTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        String transactionType = request.getParameter("transactionType");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String receiverAccountNumber = request.getParameter("receiverAccountNumber");

        // Implement transaction logic here
        // Use TransactionDAO to record the transaction

        request.setAttribute("message", "Transaction completed successfully.");
        request.getRequestDispatcher("new_transaction.jsp").forward(request, response);
    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);

        // Use CustomerDAO to update customer details
        boolean isUpdated = CustomerDAO.updateCustomer(customer);
        if (isUpdated) {
            request.setAttribute("message", "Profile updated successfully.");
        } else {
            request.setAttribute("message", "Failed to update profile.");
        }
        request.getRequestDispatcher("edit_profile.jsp").forward(request, response);
    }
}
