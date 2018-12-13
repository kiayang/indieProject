package edu.kyang.controller;
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
import java.io.PrintWriter;
import java.util.List;

/**
 * This servlet allows administrator to search or display all members
 */

@WebServlet(
        urlPatterns = {"/adminSearchMemberServlet"}
)

public class AdminSearchMemberServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        logger.info("starting the admin search member servlet");

        String email = request.getParameter("username");
        String message;
        logger.info("username = " + email);

        GenericDAO genericUserDAO = new GenericDAO(UserBean.class);

        if (email!=null && !email.isEmpty()) {
            logger.info("username is NOT empty" + email);

            List<UserBean> users = genericUserDAO.getByPropertyLike("username", email);

            logger.info("user bean = " + users);

            int userCount = users.size();

            if (userCount > 0){
                request.setAttribute("users", users);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminMemberResults.jsp");
                dispatcher.forward(request, response);
            }else {
                message = "User name " + email + " does not exist, try another search";
                httpSession.setAttribute("returnMessage", message);
                httpSession.setAttribute("errorMessage", " ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
                dispatcher.forward(request, response);
            }

        }else {
            logger.info("username is empty " + email);
            request.setAttribute("users", genericUserDAO.getAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminMemberResults.jsp");
            dispatcher.forward(request, response);
        }

    }
}