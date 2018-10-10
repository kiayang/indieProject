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
        urlPatterns = {"/searchMemberServlet"}
)

public class SearchMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Retrieve values from form
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String returnMessage;

        //instantiate MemberDAO object
        MemberDAO memberDao = new MemberDAO();

        if (req.getParameter("submit").equals("search")){
            req.setAttribute("members", memberDao.getByLastName(req.getParameter("searchTerm")));

        }else {
            req.setAttribute("members", memberDao.getAllMembers());
        }

        //forward to memberResults.jsp page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/memberResults.jsp");
        dispatcher.forward(req, resp);
    }
}