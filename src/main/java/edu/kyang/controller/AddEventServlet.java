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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * This servlet will allow admin to add add new Event to the system.
 */

@WebServlet(
        urlPatterns = {"/addEventServlet"}
)

public class AddEventServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("starting the Add Event Servlet");
        HttpSession httpSession = request.getSession();

        String userName = request.getParameter("username");
        LocalDate eventDate = LocalDate.parse(request.getParameter("eventDate"));
        BigDecimal eventFee = new BigDecimal(request.getParameter("eventFee"));
        String eventDescription = request.getParameter("eventDescription");
        String userStatus = "active";
        String message;

        GenericDAO userDAO = new GenericDAO(UserBean.class);
        List<UserBean> user = userDAO.getByPropertyEqualTwo("username",userName,"status", userStatus);
        int userSize = user.size();
        int userId = user.get(0).getId();

        if (userSize > 0) {
            logger.info("User Size = " + userSize);

            GenericDAO eventDAO = new GenericDAO(EventBean.class);
            List<EventBean> events = eventDAO.getByPropertyEqual("event_userid", userName);
            int eventSize = events.size();

            //Check for existing event before creating it
            if(eventSize == 0){

                logger.info("Event size = " + eventSize);

                EventBean eventBean = new EventBean(userName,eventDescription,eventDate,eventFee);

                eventDAO.insert(eventBean);

                String eventUserName = user.get(0).getUsername();
                int eventId = user.get(0).getId();

                //Once an event is created the user will no longer be active since this indicate they passed
                UserBean userToUpdate = (UserBean)userDAO.getById(eventId);
                String newStatus = "inactive";
                userToUpdate.setStatus(newStatus);
                userDAO.saveOrUpdate(userToUpdate);

                List<EventBean> event = eventDAO.getByPropertyEqual("event_userid", eventUserName);

                request.setAttribute("events", event);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminEventsResults.jsp");
                dispatcher.forward(request, response);
            }else{
                message = " There already is an event for member " + userName + "!";
                request.setAttribute("returnMessage", " ");
                request.setAttribute("errorMessage", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }else{
            message = userName  + " is not an active member at this time, please try again!";
            httpSession.setAttribute("returnMessage", " ");
            httpSession.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }

        //public void insert MemberEvent {}
    }
}

