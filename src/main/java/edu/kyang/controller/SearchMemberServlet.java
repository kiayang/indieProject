package edu.kyang.controller;

import edu.kyang.persistence.MemberDAO;
import edu.matc.persistence.UserDAO;

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
        urlPatterns = {"/searchMember"}
)

public class SearchMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Retrieve values from form
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String returnMessage;

        if (userName == null || userName.isEmpty()) {
            returnMessage = "User Name is Missing";
            req.setAttribute("returnMessage", returnMessage);
        } else if (password == null || password.isEmpty()) {
            returnMessage = "Password is Missing";
            req.setAttribute("returnMessage", returnMessage);
        }else {
            System.out.println("test");
        }

        //instantiate MemberDAO object
        MemberDAO memberDao = new MemberDAO();

        if (req.getParameter("submit").equals("search")){
            req.setAttribute("members", memberDao.getUsersByLastName(req.getParameter("searchTerm")));

        }else {
            req.setAttribute("members", memberDao.getAllMembers());
        }

        //forward to memberResults.jsp page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/memberResults.jsp");
        dispatcher.forward(req, resp);
    }
}