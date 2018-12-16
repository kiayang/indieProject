package edu.kyang.controller;

import edu.kyang.entity.EventBean;
import edu.kyang.entity.UserBean;
import edu.kyang.persistence.GenericDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This servlet will delete the event
 */

@WebServlet(
        urlPatterns = {"/deleteEventServlet"}
)

public class DeleteEventServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        // Allocate a output writer to write the response message into the network socket
        //PrintWriter out = response.getWriter();

        //protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve values from form
        String email = request.getParameter("username");
        String message;
        /*
        out.println("******************************");
        out.println("username = " + email);
        out.println("******************************");
        out.close();
        */

        logger.info("starting the Delete event servlet");

        GenericDAO eventDao = new GenericDAO(EventBean.class);

        logger.info("email = " + email);

        EventBean event = (EventBean) eventDao.getByPropertyEqualUnique("event_userid", email);

        logger.info("event = " + event);

        int eventId = event.getEventId();

        logger.info("Event Id = " + eventId);

        if (eventId > 0) {

            logger.info("Before Event Deleted Successfully!!");
            logger.info("user.getId() = " + eventId);

            eventDao.delete(eventDao.getById(eventId));

            logger.info("After Event Deleted Successfully!!");
            message = "User " + email + " has been deleted from system!";
            httpSession.setAttribute("returnMessage", message);
            httpSession.setAttribute("errorMessage", " ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);

        }else {

            logger.info("Event NOT Deleted Successfully!!");
            message = "Event for User name " + email + " is NOT deleted!";
            httpSession.setAttribute("returnMessage", " ");
            httpSession.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);

        }

    }
}

