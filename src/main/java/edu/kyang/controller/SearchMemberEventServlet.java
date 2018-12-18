package edu.kyang.controller;
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
import java.util.List;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/searchMemberEventServlet"}
)

public class SearchMemberEventServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.debug("starting the Search User Event Servlet");

        String username = request.getParameter("username");
        HttpSession httpSession = request.getSession();

        GenericDAO userDao = new GenericDAO(UserBean.class);
        GenericDAO userEventDao = new GenericDAO(UserEventBean.class);
        String message;

        if (username!=null && !username.isEmpty()) {
            logger.info("*** Display username not null and username not empty");
            logger.info("*** Display username entry: " + username);

            List<UserBean> users = userDao.getByPropertyEqual("username", username);

            int userSize = users.size();
            logger.info("*** Display userSize: " + userSize);

            if (userSize > 0) {
                int userid = users.get(0).getId();
                logger.info("*** Display userid: " + userid);
                List<UserEventBean> userEvents = userEventDao.getByPropertyEqualInt("ueId", userid);

                int ueSize = userEvents.size();

                logger.info("*** user events size: " + ueSize);

                if (ueSize > 0) {
                    logger.info("Display User Event Bean : " + userEvents);

                    httpSession.setAttribute("userEvents", userEvents);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/displayMemberEventsResults.jsp");
                    dispatcher.forward(request, response);
                } else {
                    message = "There are no Events for " + username + "!";
                    request.setAttribute("returnMessage", message);
                    request.setAttribute("errorMessage", " ");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                    dispatcher.forward(request, response);
                }
            }else {
                message = "There are no Events for " + username + "!";
                request.setAttribute("returnMessage", message);
                request.setAttribute("errorMessage", " ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }else {
            logger.info("*** Display Username is either null or empty, get all user events");
            logger.info("*** Display username entry: " + username);

            List<UserEventBean> userEvents = userEventDao.getAll();
            int ueSize = userEvents.size();

            if (ueSize > 0){
                httpSession.setAttribute("userEvents", userEvents);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayMemberEventsResults.jsp");
                dispatcher.forward(request, response);
            }else {
                message = "There are user events!";
                request.setAttribute("returnMessage", message);
                request.setAttribute("errorMessage", " ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }

    }
}