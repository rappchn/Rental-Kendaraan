/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalkendaraan.controller;

import com.mycompany.rentalkendaraan.model.DatabaseConnection;
import com.mycompany.rentalkendaraan.model.kendaraan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/tambahKendaraan")
public class kendaraanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String merk  = request.getParameter("merk");
        String tahun = request.getParameter("tahun");
        String plat  = request.getParameter("plat");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO kendaraan (merk, tahun, plat) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, merk);
            stmt.setString(2, tahun);
            stmt.setString(3, plat);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("sukses.jsp");
            } else {
                response.getWriter().println("Gagal menambahkan kendaraan.");
            }
        } catch (Exception e) {
            e.printStackTrace();                // cetak detail error ke console NetBeans
            response.getWriter().println("Gagal menambahkan kendaraan: " + e.getMessage());
        }
    }
}


