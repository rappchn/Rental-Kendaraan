<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </body>
</html>
