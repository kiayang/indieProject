package edu.kyang.controller;
import edu.kyang.entity.EventBean;
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
import java.util.List;

/**
 * This servlet will retrieve events and forward results to jsp page for display.
 */

@WebServlet(
        urlPatterns = {"/searchEventServlet"}
)

public class SearchEventServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("starting the Search Event Servlet");
        HttpSession httpSession = request.getSession();

        String submit = request.getParameter("submit");
        String searchTerm = request.getParameter("searchTerm");
        String message;

        logger.info("Submit value: " + submit + "  Search Term: " + searchTerm);

        if (searchTerm.isEmpty()) {

            logger.info("*** No Search Term Entered: " + searchTerm);

            GenericDAO eventDao = new GenericDAO(EventBean.class);

            List<EventBean> events = eventDao.getAll();

            int eventSize = events.size();
            logger.info("Event Size: " + eventSize);
            logger.info("EventBean List: " + events);

            if (eventSize > 0) {
                logger.info("Event Size > zero: " + eventSize);
                request.setAttribute("events", events);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminEventsResults.jsp");
                dispatcher.forward(request, response);
            } else {
                message = "No events found for username " + searchTerm + " try another search!";
                request.setAttribute("returnMessage", message);
                request.setAttribute("errorMessage", " ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        } else if (request.getParameter("submit").equals("username")) {
            logger.info("**** Search Term IS Entered for Username: " + searchTerm);
            logger.info("Search by username!");
            logger.info("Submit value: " + submit + "  Search Term: " + searchTerm);

            GenericDAO eventDao = new GenericDAO(EventBean.class);

            List<EventBean> events = eventDao.getByPropertyEqual("event_userid", searchTerm);

            int eventSize = events.size();

            if (eventSize > 0) {

                logger.info("Event found for User Id " + searchTerm + " size > 0" + " Size is " + eventSize);

                request.setAttribute("events", events);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminEventsResults.jsp");
                dispatcher.forward(request, response);

            }else{
                logger.info("NO Event found for  " + searchTerm);

                message = "No events found with user name " + searchTerm + " try another search!";
                request.setAttribute("returnMessage", " ");
                request.setAttribute("errorMessage", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        } else {
            logger.info("**** Search Term IS Entered for Description: " + searchTerm);
            GenericDAO eventDao = new GenericDAO(EventBean.class);

            List<EventBean> events = eventDao.getByPropertyLike("description", searchTerm);

            int eventSize = events.size();

            if (eventSize > 0) {

                logger.info("Event found for User Description Like " + searchTerm + "size > 0");

                request.setAttribute("events", events);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminEventsResults.jsp");
                dispatcher.forward(request, response);

            }else{
                logger.info("Search by description!");
                logger.info("Submit value: " + submit + "  Search Term: " + searchTerm);

                message = "No events found with description " + searchTerm + " try another search!";
                request.setAttribute("returnMessage", " ");
                request.setAttribute("errorMessage", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }
    }

}