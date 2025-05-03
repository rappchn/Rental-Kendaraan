<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionlogin = request.getSession(false);
    if (sessionlogin == null || session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tambah Kendaraan</title>
    </head>
    <body>
        <h1>Form Tambah Kendaraan</h1>
        <form method="post" action="tambahKendaraan">
            <label>Merk:</label><br>
            <input type="text" name="merk" required><br><br>

            <label>Tahun:</label><br>
            <input type="text" name="tahun" required><br><br>

            <label>Plat:</label><br>
            <input type="text" name="plat" required><br><br>

            <input type="submit" value="Simpan">
        </form>
        <a href="logout">Logout</a>
    </body>
</html>
