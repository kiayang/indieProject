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
import java.util.List;

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

        int eventid = Integer.parseInt(request.getParameter("eventid"));
        String message;

        logger.info("****** starting the Delete event servlet ********");

        GenericDAO eventDao = new GenericDAO(EventBean.class);

        logger.info(" ** Print Event Id entered = " + eventid);

        List<EventBean> events = eventDao.getByPropertyEqualInt("eventId", eventid);
        int eventSize = events.size();

        logger.info("Event Size = " + eventSize);
        logger.info("Event Bean List Before = " + events);
        if (eventSize > 0) {
            //int eventId = events.get(0).getEventId();
            logger.info("Before Event Deleted Successfully!!");
            logger.info("events.getId() = " + eventid);

            eventDao.delete(eventDao.getById(eventid));

            List<EventBean> eventList = eventDao.getAll();
            logger.info("Event List After = " + eventList);

            logger.info("After Event Deleted Successfully!!");
            message = "Event " + eventid + " has been deleted from system!";
            request.setAttribute("returnMessage", message);
            request.setAttribute("errorMessage", " ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);

        }else {

            logger.info("Event NOT Deleted Successfully!!");
            message = "Event " + eventid + " does not exists and does NOT need to be deleted!";
            request.setAttribute("returnMessage", " ");
            request.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);

        }

    }
}

