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
        String message;

        GenericDAO userDAO = new GenericDAO(UserBean.class);
        List<UserBean> users = userDAO.getByPropertyEqual("username", userName);

        int usersBoolean = users.size();

        if (usersBoolean > 0) {
            logger.info("Users Boolean = " + usersBoolean);

            GenericDAO eventDAO = new GenericDAO(EventBean.class);
            List<EventBean> events = eventDAO.getByPropertyEqual("event_userid", userName);
            int eventsBoolean = events.size();

            if(eventsBoolean == 0){
                logger.info("Events Boolean = " + eventsBoolean);

                EventBean eventBean = new EventBean(userName,eventDescription,eventDate,eventFee);

                eventDAO.insert(eventBean);

                int uID = users.get(0).getId();

                UserBean retrievedUserBefore = (UserBean) userDAO.getById(uID);
                String beforeStatus = retrievedUserBefore.getStatus();

                logger.info("User Status Before update = " + beforeStatus);

                if ("active".equals(beforeStatus)){

                    UserBean userToUpdate = (UserBean)userDAO.getById(uID);
                    String newStatus = "inactive";
                    userToUpdate.setStatus(newStatus);
                    userDAO.saveOrUpdate(userToUpdate);
                    UserBean retrievedUserAfter = (UserBean) userDAO.getById(uID);
                    String updatedStatus = retrievedUserAfter.getStatus();

                    message = "New event for " + userName + " has been added and member status has been updated to " + updatedStatus;
                    httpSession.setAttribute("returnMessage", message);
                    httpSession.setAttribute("errorMessage", " ");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                    dispatcher.forward(request, response);
                }else{
                    message = "Member " + userName + " is not active, an event cannot be added at this time!";
                    httpSession.setAttribute("returnMessage", " ");
                    httpSession.setAttribute("errorMessage", message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                    dispatcher.forward(request, response);
                }


            }else{
                message = "There is already an event created for " + userName;
                httpSession.setAttribute("returnMessage", " ");
                httpSession.setAttribute("errorMessage", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }
        }else{
            message = userName  + " is not a member, please try again!";
            httpSession.setAttribute("returnMessage", " ");
            httpSession.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }
    }
}

