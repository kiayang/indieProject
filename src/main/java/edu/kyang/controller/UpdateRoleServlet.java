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
 * This servlet will update event info on the event table
 */

@WebServlet(
        urlPatterns = {"/updateRoleServlet"}
)

public class UpdateRoleServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("starting the update member Role servlet");
        logger.info("*** Inside doPost Method ***");

        HttpSession httpSession = request.getSession();

        int roleid = Integer.parseInt(request.getParameter("roleid"));
        String updateRole = request.getParameter("role");
        String message;


        logger.info("Role before: " + updateRole);
        logger.info("*** BEFORE updateToUpdate ***");

        GenericDAO userRoleDao = new GenericDAO(UserRoleBean.class);
        List<UserRoleBean> userRoles = userRoleDao.getByPropertyEqualInt("id", roleid);
        logger.info("*** After get user Role by username ***");

        if (userRoles.size() > 0){
            logger.info("username: " + userRoles);

            UserRoleBean userToUpdate = (UserRoleBean)userRoleDao.getById(roleid);
            userToUpdate.setUserRole(updateRole);
            userRoleDao.saveOrUpdate(userToUpdate);


            List<UserRoleBean> retrieveRoleList = userRoleDao.getByPropertyEqualInt("id",roleid);

            logger.info("retrieve Role List = " + retrieveRoleList);

            message = "User Role for Id " + roleid + " has been updated to " + updateRole;
            request.setAttribute("returnMessage", message);
            request.setAttribute("errorMessage", " ");
            httpSession.setAttribute("roles", retrieveRoleList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayAdminRoleResults.jsp");
            dispatcher.forward(request, response);

        }else{
            message = "Role Id " + roleid + " is not found, try again!!";
            request.setAttribute("returnMessage", " ");
            request.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }

    }
}

