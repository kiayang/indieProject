package edu.kyang.controller;
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
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/updateMemberRoleServlet"}
)

public class UpdateMemberRoleServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("starting the update member Role servlet");
        logger.info("*** Inside doPost Method ***");

        HttpSession httpSession = request.getSession();

        String email = request.getParameter("username");
        String role = request.getParameter("role");
        String message;


        logger.info("Role before: " + role);
        logger.info("*** BEFORE updateToUpdate ***");

        GenericDAO userRoleDao = new GenericDAO(UserRoleBean.class);
        List<UserRoleBean> userRoles = userRoleDao.getByPropertyEqual("username", email);
        logger.info("*** After get user Role by username ***");

        if (userRoles.size() > 0){
            int roleid = userRoles.get(0).getId();
            logger.info("roleid: " + roleid);

            UserRoleBean userToUpdate = (UserRoleBean)userRoleDao.getById(roleid);

            userToUpdate.setUserRole(role);

            userRoleDao.saveOrUpdate(userToUpdate);
            UserRoleBean retrievedUser = (UserRoleBean) userRoleDao.getById(roleid);
            String retrieveRole = retrievedUser.getUserRole();

            logger.info("retrieve Role = " + retrieveRole);

            message = "User Role for " + email + " has been updated to " + retrieveRole;
            httpSession.setAttribute("returnMessage", message);
            httpSession.setAttribute("errorMessage", " ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);

        }else{
            message = "User name " + email + " is not found, try again!!";
            httpSession.setAttribute("returnMessage", " ");
            httpSession.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }

    }
}

