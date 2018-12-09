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

        PrintWriter out = response.getWriter();

        String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        BigDecimal eventFee = new BigDecimal(request.getParameter("eventFee"));
        String message;

        out.println("******************************");
        out.println("Event Name = " + eventName);
        out.println("Event Date = " + eventDate);
        out.println("Event Fee = " + eventFee);
        out.println("******************************");
        out.close();

    /*
        GenericDAO userDAO = new GenericDAO(UserBean.class);
        GenericDAO userRoleDAO = new GenericDAO(UserRoleBean.class);

        List<UserBean> userNames = userDAO.getByPropertyEqual("username", email);

        int usersBoolean = userNames.size();

        if (usersBoolean == 0) {

            UserBean userBean = new UserBean(email, status, password, firstname, lastname, middlename, birthdate, address, state, zipcode, phone);
            UserRoleBean userRoleBean = new UserRoleBean(userBean,email,userRole);

            userDAO.insert(userBean);
            userRoleDAO.insert(userRoleBean);

            message = "User " + email + " has been registered as a member and will be contacted soon!";
            httpSession.setAttribute("returnMessage", message);
            httpSession.setAttribute("errorMessage", " ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }else {
            message = "User name " + email + " has already been registered! Enter a different user name!";
            httpSession.setAttribute("returnMessage", " ");
            httpSession.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }
      */
    }
}

