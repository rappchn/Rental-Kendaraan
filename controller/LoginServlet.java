/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalkendaraan.controller;
import com.mycompany.rentalkendaraan.model.DatabaseConnection;

import com.mycompany.rentalkendaraan.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author Rappchn
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (Admin.authenticate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", username);
            response.sendRedirect("tambah.jsp");
        } else {
            request.setAttribute("error", "Username atau password salah.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
