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
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

/**
 * This servlet will delete the member
 */

@WebServlet(
        urlPatterns = {"/deleteMemberServlet"}
)

public class DeleteMemberServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userid"));
        String message;

        logger.info("starting the delete member servlet");

        GenericDAO userDao = new GenericDAO(UserBean.class);

        List<UserBean> users = userDao.getByPropertyEqualInt("id", userid);
        int userSize = users.size();

        logger.info("user size = " + userSize);

        if (userSize > 0) {
            logger.info("Before Member Deleted Successfully!!");

            userDao.delete(userDao.getById(userid));

            logger.info("After Member Deleted Successfully!!");
            message = "User Id " + userid + " has been deleted from system!";
            request.setAttribute("returnMessage", message);
            request.setAttribute("errorMessage", " ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);

        }else {

            logger.info("Member NOT Deleted Successfully!!");
            message = "User Id " + userid + " does NOT exists and does not need to be deleted!";
            request.setAttribute("returnMessage", " ");
            request.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);

        }

    }
}

