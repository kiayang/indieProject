package edu.kyang.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * A simple servlet to welcome the user.
 */

@WebServlet(
        urlPatterns = {"/deleteMemberServlet"}
)

public class DeleteMemberServlet extends HttpServlet {

    //private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        //protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve values from form
        String email = request.getParameter("username");

        out.println("******************************");
        out.println("username = " + email);
        out.println("******************************");
        out.close();

    }
}

