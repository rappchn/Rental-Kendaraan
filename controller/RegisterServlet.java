/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalkendaraan.controller;

import com.mycompany.rentalkendaraan.model.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DatabaseConnection.getConnection()) {
            // 1) Cek apakah username sudah ada
            String cekSql = "SELECT COUNT(*) FROM admin WHERE username = ?";
            try (PreparedStatement cekStmt = conn.prepareStatement(cekSql)) {
                cekStmt.setString(1, username);
                ResultSet rs = cekStmt.executeQuery();
                rs.next();
                if (rs.getInt(1) > 0) {
                    // username sudah dipakai
                    request.setAttribute("error", "Username sudah digunakan, silakan pilih username lain.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    return;
                }
            }

            // 2) Jika belum ada, lakukan insert
            String insertSql = "INSERT INTO admin (username, password) VALUES (?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, password); // di production: simpan hash!
                insertStmt.executeUpdate();
            }

            // 3) Redirect ke login dengan parameter sukses
            response.sendRedirect("login.jsp?success=registered");

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Gagal mendaftar: " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}


