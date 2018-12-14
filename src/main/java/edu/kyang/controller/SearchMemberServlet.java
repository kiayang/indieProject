package edu.kyang.controller;
import edu.kyang.entity.EventBean;
import edu.kyang.entity.UserBean;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/searchMemberMenuServlet"}
)

public class SearchMemberServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        logger.debug("starting the Add Event Servlet");

        String username = req.getRemoteUser();

        if (req.getParameter("submit").equals("viewProfile")){
            GenericDAO genericUserDAO = new GenericDAO(UserBean.class);
            UserBean user = (UserBean)genericUserDAO.getByPropertyEqualUnique("username", username);
            int userId = user.getId();
            user = (UserBean)genericUserDAO.getById(userId);
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/displayMemberResults.jsp");
            dispatcher.forward(req, resp);
        }else {


            logger.info("Display all events related to the username");
            /*
            GenericDAO userEventDao = new GenericDAO(UserEventBean.class);
            List<UserEventBean> userEvents = userEventDao.getByPropertyEqual("event_userid", username);
            int size = userEvents.size();
            int userEventId = userEvents.get(0).getUE_id());

            req.setAttribute("userevents", userEvents);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/displayUserEventsResults.jsp");
            dispatcher.forward(req, resp);
            */
        }

    }
}