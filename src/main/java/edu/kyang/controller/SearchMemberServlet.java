package edu.kyang.controller;
import edu.kyang.entity.UserBean;
import edu.kyang.entity.UserRoleBean;
import edu.kyang.persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/searchMemberServlet"}
)

public class SearchMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = resp.getWriter();

        //Retrieve values from form
        String username = req.getRemoteUser();
        String firstName = req.getParameter("firstname");
        String returnMessage;

        /*
        out.println("Welcome '" + req.getRemoteUser() + "'");
        out.println("******************************");
        out.println("username = " + username);
        //out.println("password = " + password);
        out.println("******************************");
        */

        //GenericDAO genericEventDAO = new GenericDAO(EventBean.class);
        //List<EventBean> events = (EventBean)genericEventDAO.getByPropertyEqualObject("event", event);
        GenericDAO genericUserDAO = new GenericDAO(UserBean.class);
        UserBean user = (UserBean)genericUserDAO.getByPropertyEqualUnique("username", username);
        int userId = user.getId();
        user = (UserBean)genericUserDAO.getById(userId);

        if (req.getParameter("submit").equals("viewProfile")){
            req.setAttribute("user", user);
            //out.println("View Profile!");
            //forward to memberResults.jsp page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/displayMemberResults.jsp");
            dispatcher.forward(req, resp);
        }else {
            //req.setAttribute("events", events);
            //req.setAttribute("eventNumber", events.size())
            //out.println("View Events!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/displayMemberEventsResults.jsp");
            dispatcher.forward(req, resp);
        }

        //out.close();
    }
}