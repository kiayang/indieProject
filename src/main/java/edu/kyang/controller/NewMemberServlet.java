package edu.kyang.controller;
import edu.kyang.entity.UserBean;
import edu.kyang.persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to forward member to the registration page
 */

@WebServlet(
        urlPatterns = {"/newMemberServlet"}
)

public class NewMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addMember.jsp");
        dispatcher.forward(req, resp);
    }

}
