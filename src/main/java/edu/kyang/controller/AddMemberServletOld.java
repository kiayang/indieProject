package edu.kyang.controller;
import edu.kyang.entity.UserBean;
import edu.kyang.entity.UserRoleBean;
import edu.kyang.persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/addMemberServlet"}
)

public class AddMemberServletOld extends HttpServlet {

    //private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        // Allocate a output writer to write the response message into the network socket
        /*
        PrintWriter out = response.getWriter();
        */
        //protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve values from form
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String middlename = request.getParameter("middlename");
        String password = request.getParameter("password");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String phone = request.getParameter("phone");
        String status = "new";
        String userRole = "register";
/*
        out.println("******************************");
        out.println("email = " + email);
        out.println("password = " + password);
        out.println("******************************");
        out.close();
        */

        GenericDAO userDao = new GenericDAO(UserBean.class);
        GenericDAO userRoleDao = new GenericDAO(UserRoleBean.class);

        UserBean userBean = new UserBean(email,status,password,firstname,lastname,middlename,birthdate,address,state,zipcode,phone);
        UserRoleBean userRoleBean = new UserRoleBean(userBean,email,userRole);

        userDao.insert(userBean);
        userRoleDao.insert(userRoleBean);

        //forward to memberResults.jsp page

        //log.info(email + " member added!");
        String message = "User " + email + " has been registered as a member and will be contacted soon!";
        httpSession.setAttribute("returnmessage", message);
        //httpSession.setAttribute("returnmessage", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addMemberResult.jsp");
        dispatcher.forward(request, response);
    }
}