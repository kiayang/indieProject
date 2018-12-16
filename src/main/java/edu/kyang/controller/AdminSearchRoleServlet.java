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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * This servlet will retrieve members and related roles and forward results to jsp page for display.
 */

@WebServlet(
        urlPatterns = {"/adminSearchRoleServlet"}
)

public class AdminSearchRoleServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        logger.info("starting the admin search member Role servlet");

        String email = request.getParameter("username");
        String message;
        logger.info("username = " + email);

        GenericDAO genericRoleDAO = new GenericDAO(UserRoleBean.class);

        if (email!=null && !email.isEmpty()) {
            logger.info("username is NOT empty" + email);

            List<UserRoleBean> userRoles = genericRoleDAO.getByPropertyLike("username", email);

            logger.info("user role bean = " + userRoles);

            int userCount = userRoles.size();

            if (userCount > 0){
                httpSession.setAttribute("roles", userRoles);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminRoleResults.jsp");
                dispatcher.forward(request, response);
            }else {
                message = "User name " + email + " does not exist, try another search";
                request.setAttribute("returnMessage", message);
                request.setAttribute("errorMessage", " ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }else {
            logger.info("username is empty " + email);
            httpSession.setAttribute("roles", genericRoleDAO.getAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminRoleResults.jsp");
            dispatcher.forward(request, response);
        }

    }

}