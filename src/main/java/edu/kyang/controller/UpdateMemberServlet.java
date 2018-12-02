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
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/updateMemberServlet"}
)

public class UpdateMemberServlet extends HttpServlet {

    //private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        //protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve values from form
        String userid = request.getParameter("userid");
        String email = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String middlename = request.getParameter("middlename");


        String password = request.getParameter("password");
        LocalDate dateofbirth = LocalDate.parse(request.getParameter("dateofbirth"));
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String phone = request.getParameter("phone");
        String status = "status";
        String message;


        out.println("******************************");
        out.println("userid = " + userid);
        out.println("username = " + email);
        out.println("firstname = " + firstname);
        out.println("lastname = " + lastname);
        out.println("middlename = " + middlename);

        out.println("password = " + password);
        out.println("dateofbirth = " + dateofbirth);
        out.println("address = " + address);
        out.println("state = " + state);

        out.println("zipcode = " + zipcode);
        out.println("phone = " + phone);
        out.println("status = " + status);
        out.println("******************************");
        out.close();

    }
}

