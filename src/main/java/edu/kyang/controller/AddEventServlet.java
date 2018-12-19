package edu.kyang.controller;
import edu.kyang.entity.EventBean;
import edu.kyang.entity.UserBean;
import edu.kyang.entity.UserEventBean;
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

        String email = request.getParameter("username");
        LocalDate eventDate = LocalDate.parse(request.getParameter("eventDate"));
        BigDecimal eventFee = new BigDecimal(request.getParameter("eventFee"));
        String eventDescription = request.getParameter("eventDescription");
        String userStatus = "active";
        String message;
        int userSize;

        GenericDAO userDAO = new GenericDAO(UserBean.class);

        // Search to ensure the event is for an 'active' member, if the member is not active that means that they are no longer
        // a member and there will not need to be an event created for the member
        List<UserBean> user = userDAO.getByPropertyEqualTwo("username",email,"status", userStatus);
        userSize = user.size();

        //If the member is 'active', create an event for the member and then updated the member to 'inactive'
        if (userSize > 0) {
            logger.info("User Size = " + userSize);

            GenericDAO eventDAO = new GenericDAO(EventBean.class);
            List<EventBean> events = eventDAO.getByPropertyEqual("event_userid", email);
            int eventSize = events.size();

            //Check to ensure that there isn't already an event created for the deceased member before creating the event
            if(eventSize == 0){

                logger.info("There has not been an event created. Event size = " + eventSize);

                //instantiate and set values for update
                EventBean eventBean = new EventBean(email,eventDescription,eventDate,eventFee);

                //Updated event with the values from parameters passed above
                int eventid = eventDAO.insert(eventBean);
                EventBean newEventId = (EventBean) eventDAO.getById(eventid);

                //Get the username for the member that is being updated
                String userName = user.get(0).getUsername();
                //Get the event id for the member that is being updated
                int userId = user.get(0).getId();

                //Instantiate the user bean and update the status to 'inactive' after the event has been created
                UserBean userToUpdate = (UserBean)userDAO.getById(userId);
                String newStatus = "inactive";
                userToUpdate.setStatus(newStatus);
                userDAO.saveOrUpdate(userToUpdate);

                /** Create an event for each active member on the user_event table, initially setting the paid status and
                *  paid date to null (admin can update later as members make the payments)
                */
                //Retrieve list of all active members from user table
                List<UserBean> userList = userDAO.getByPropertyEqual("status",userStatus);
                userSize = user.size();

                if (userSize > 0){

                    System.out.println("****PRINT USER LIST ***********************");
                    for (UserBean users : userList) {
                        System.out.println("UserList- user Id: " + users.getId());
                        System.out.println("Event id: " + eventid);

                        int id = users.getId();
                        UserBean newUserid = (UserBean)userDAO.getById(id);

                        //Instantiate and set the values that will need to be updated
                        GenericDAO userEventDAO = new GenericDAO(UserEventBean.class);
                        UserEventBean newUserEventBean = new UserEventBean(newUserid,newEventId,null,null);

                        //INSERT new row to UserEvent table for the Event and User retrieved above
                        int ueId = userEventDAO.insert(newUserEventBean);
                        UserEventBean insertedUserEvent = (UserEventBean) userEventDAO.getById(ueId);
                        logger.info("User Event - After Insert : " + insertedUserEvent);
                    }

                }

                //Retrieve the new event and display on jsp result page
                List<EventBean> eventList = eventDAO.getByPropertyEqual("event_userid", userName);
                httpSession.setAttribute("events", eventList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminEventsResults.jsp");
                dispatcher.forward(request, response);
            }else{
                message = " There already is an event for member " + email + "!";
                request.setAttribute("returnMessage", " ");
                request.setAttribute("errorMessage", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }else{
            message = email  + " is not an active member at this time, please try again!";
            request.setAttribute("returnMessage", " ");
            request.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }

    }
}

