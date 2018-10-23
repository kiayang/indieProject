package edu.kyang.controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/searchMemberServlet"}
)

public class SearchMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = resp.getWriter();

        //Retrieve values from form
        String username = req.getParameter("username");
        out.println("Welcome '" + req.getRemoteUser() + "'");
        String password = req.getParameter("firstname");
        String returnMessage;
        out.println("******************************");
        out.println("username = " + username);
        out.println("password = " + password);
        out.println("******************************");
        out.close();
        //GenericDAO memberDAO = new GenericDAO(UserBean.class);
        /*
        if (req.getParameter("submit").equals("search")){
            req.setAttribute("users", genericDao.getById(req.getParameter("searchTerm")));

        }else {
            req.setAttribute("users", genericDao.getAll());
        }
        */
        //forward to memberResults.jsp page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/memberResults.jsp");
        dispatcher.forward(req, resp);
    }
}