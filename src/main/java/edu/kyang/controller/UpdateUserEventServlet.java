package edu.kyang.controller;
import edu.kyang.entity.UserEventBean;
import edu.kyang.entity.UserRoleBean;
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
import java.time.LocalDate;
import java.util.List;

/**
 * This servlet will update the paid status and paid date on the user event table
 */

@WebServlet(
        urlPatterns = {"/updateUserEventServlet"}
)

public class UpdateUserEventServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("starting the update User Event servlet");
        logger.info("*** Inside doPost Method ***");

        HttpSession httpSession = request.getSession();

        int ueId = Integer.parseInt(request.getParameter("ue_id"));
        String status = request.getParameter("status");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String message;

        logger.info("*** BEFORE updateToUpdate ***");

        GenericDAO userEventDao = new GenericDAO(UserEventBean.class);
        List<UserEventBean> userEvents = userEventDao.getByPropertyEqualInt("ueId", ueId);

        if (userEvents.size() > 0){
            logger.info("username: " + userEvents);

            //int ue_id = userEvents.get(0).getUeId();
            UserEventBean ueToUpdate = (UserEventBean)userEventDao.getById(ueId);
            ueToUpdate.setUePaidStatus(status);
            ueToUpdate.setUePaidDate(date);
            userEventDao.saveOrUpdate(ueToUpdate);

            List<UserEventBean> retrieveEventList = userEventDao.getByPropertyEqualInt("ueId",ueId);

            message = "Event paid status/date has been updated successfully for the user!";
            request.setAttribute("returnMessage", message);
            request.setAttribute("errorMessage", " ");
            httpSession.setAttribute("userEvents", retrieveEventList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayMemberEventsResults.jsp");
            dispatcher.forward(request, response);

        }else{
            message = "User Event not found, try again!!";
            request.setAttribute("returnMessage", " ");
            request.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }

    }
}

