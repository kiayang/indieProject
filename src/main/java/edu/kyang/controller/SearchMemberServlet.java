package edu.kyang.controller;
import edu.kyang.entity.UserBean;
import edu.kyang.persistence.GenericDAO;
import javax.persistence.Table;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/searchMemberServlet"}
)

public class SearchMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Retrieve values from form
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String returnMessage;

        GenericDAO memberDAO = new GenericDAO(UserBean.class);
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