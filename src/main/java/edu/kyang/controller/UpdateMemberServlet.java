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
 * This servlet will update the member information.
 */

@WebServlet(
        urlPatterns = {"/updateMemberServlet"}
)

public class UpdateMemberServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("starting the Update Member Servlet");
        logger.info("*** Inside doPost Method ***");

        HttpSession httpSession = request.getSession();

        String userid = request.getParameter("userid");
        String email = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String middlename = request.getParameter("middlename");
        String password = request.getParameter("password");
        String dateofbirth = request.getParameter("dateofbirth");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");
        String message;

        logger.info("*** BEFORE Update ***");
        logger.info("first name: " + firstname);
        logger.info("last name: " + lastname);
        logger.info("last name: " + dateofbirth);

        GenericDAO userDAO = new GenericDAO(UserBean.class);

        List<UserBean> users = userDAO.getByPropertyEqual("username", email);

        if (users.size() > 0){

            int uID = users.get(0).getId();

            logger.info("user id = " + uID);

            UserBean userToUpdate = (UserBean)userDAO.getById(uID);

            if ( firstname!=null && !firstname.isEmpty()  )	{
                userToUpdate.setFirstname(firstname);
            }

            if ( lastname!=null && !lastname.isEmpty()  )	{
                userToUpdate.setLastname(lastname);
            }

            if ( middlename!=null && !middlename.isEmpty()  )	{
                userToUpdate.setMiddlename(middlename);
            }

            if ( password!=null && !password.isEmpty()  )	{
                userToUpdate.setPassword(password);
            }

            if (!"9999-12-31".equals(dateofbirth)){

                LocalDate dob = LocalDate.parse(dateofbirth);
                userToUpdate.setDateofbirth(dob);
            }


            if ( address!=null && !address.isEmpty()  )	{
                userToUpdate.setAddress(address);
            }

            if ( state!=null && !state.isEmpty()  )	{
                userToUpdate.setState(state);
            }

            if ( zipcode!=null && !zipcode.isEmpty()  )	{
                userToUpdate.setZipcode(zipcode);
            }

            if ( phone!=null && !phone.isEmpty()  )	{
                userToUpdate.setPhone(phone);
            }

            if ( status!=null && !status.isEmpty()  )	{
                userToUpdate.setStatus(status);
            }

            userDAO.saveOrUpdate(userToUpdate);
            UserBean retrievedUser = (UserBean) userDAO.getById(uID);
            String retrieveUserFname = retrievedUser.getFirstname();
            logger.info("updated first name = " + retrieveUserFname);

            String retrieveUserLname = retrievedUser.getLastname();
            logger.info("updated last name = " + retrieveUserLname);
            message = "User " + email + " has been updated successfully!!";
            httpSession.setAttribute("returnMessage", message);
            httpSession.setAttribute("errorMessage", " ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }else{
            logger.info("User not found");
            message = "User name " + email + " is not found, try again!!";
            httpSession.setAttribute("returnMessage", " ");
            httpSession.setAttribute("errorMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReturnMessage.jsp");
            dispatcher.forward(request, response);
        }

    }
}

