<%-- 
    Document   : list
    Created on : May 3, 2025, 10:41:53 AM
    Author     : Rappchn
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Daftar Kendaraan</title>
</head>
<body>
    <h2>Daftar Kendaraan</h2>

    <!-- Tampilkan pesan error jika ada -->
    <c:if test="${not empty errorMessage}">
        <div style="color:red">${errorMessage}</div>
    </c:if>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Merk</th>
            <th>Tahun</th>
            <th>Plat</th>
        </tr>
        <!-- Iterasi listKendaraan yang di-set oleh servlet -->
        <c:forEach var="k" items="${listKendaraan}">
            <tr>
                <td><c:out value="${k.merk}"/></td>
                <td><c:out value="${k.tahun}"/></td>
                <td><c:out value="${k.plat}"/></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="tambah.jsp">Tambah Kendaraan Lagi</a>
</body>
</html>

