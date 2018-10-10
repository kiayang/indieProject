package edu.kyang.controller;

import edu.kyang.persistence.MemberDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/loginServlet"}
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve values from form
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String returnMessage;

        //forward to memberResults.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/memberResults.jsp");
        dispatcher.forward(request, response);
    }
}