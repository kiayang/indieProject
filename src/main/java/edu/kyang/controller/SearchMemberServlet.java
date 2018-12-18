package edu.kyang.controller;
import edu.kyang.entity.EventBean;
import edu.kyang.entity.UserBean;
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
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/searchMemberServlet"}
)

public class SearchMemberServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.debug("starting the Search Member/Event Servlet");
        HttpSession httpSession = request.getSession();
        String username = request.getRemoteUser();
        GenericDAO userDao = new GenericDAO(UserBean.class);
        GenericDAO userEventDao = new GenericDAO(UserEventBean.class);
        String message;

        if (request.getParameter("submit").equals("viewProfile")){

            UserBean user = (UserBean)userDao.getByPropertyEqualUnique("username", username);
            int userId = user.getId();
            user = (UserBean)userDao.getById(userId);
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayMemberResults.jsp");
            dispatcher.forward(request, response);
        }else {

            logger.info("*** Display all events related to the username");

            List<UserBean> users = userDao.getByPropertyEqual("username", username);
            int userid = users.get(0).getId();
            logger.info("*** Display userid: " + userid);
            List<UserEventBean> userEvents = userEventDao.getByPropertyEqualInt("ueId",userid);

            int ueSize = userEvents.size();

            logger.info("*** user events size: " + ueSize);

            if (ueSize > 0) {
                logger.info("Display User Event Bean : " + userEvents);

                httpSession.setAttribute("userEvents", userEvents);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayMemberEventsResults.jsp");
                //httpSession.setAttribute("users", users);
                //RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminMemberResults.jsp");
                dispatcher.forward(request, response);
            }else {
                message = "There are no Events for " + username + "!";
                request.setAttribute("returnMessage", message);
                request.setAttribute("errorMessage", " ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }

    }
}