package edu.kyang.controller;
import edu.kyang.entity.UserBean;
import edu.kyang.entity.UserRoleBean;
import edu.kyang.persistence.GenericDAO;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/addMemberServlet"}
)

public class AddMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String returnMessage;
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
        UserRoleBean userRoleBean = new UserRoleBean(email,userRole,userBean);

        // Set child reference(userRole) in parent entity(user)
        //userBean.setUserRole(userRoleBean);

        // Set parent reference(user) in child entity(userRole)
        //userRoleBean.setUser(userBean);

        // Save Parent Reference (which will save the child as well)
        //userRoleDao.saveOrUpdate(userBean);
        //userDao.saveOrUpdate(userBean);
        userDao.saveOrUpdate(userBean);

        /*
        // Create a User instance
                User user = new User("Rajeev", "Singh", "rajeev@callicoder.com",
                "MY_SUPER_SECRET_PASSWORD");

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);

        // Create a UserProfile instance
        UserProfile userProfile = new UserProfile("+91-8197882053", Gender.MALE, dateOfBirth.getTime(),
                "747", "2nd Cross", "Golf View Road, Kodihalli", "Bangalore",
                "Karnataka", "India", "560008");


        // Set child reference(userProfile) in parent entity(user)
        user.setUserProfile(userProfile);

        // Set parent reference(user) in child entity(userProfile)
        userProfile.setUser(user);

        // Save Parent Reference (which will save the child as well)
        userRepository.save(user);

        //=========================================*/


        /*
        if (req.getParameter("submit").equals("search")){
            req.setAttribute("users", genericDao.getById(req.getParameter("searchTerm")));

        }else {
            req.setAttribute("users", genericDao.getAll());
        }
        */
        //forward to memberResults.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addMemberResult.jsp");
        dispatcher.forward(request, response);
    }
}