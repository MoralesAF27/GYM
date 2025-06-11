package Servlet;

import Control.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configurar codificación
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Obtener parámetros
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");

        // Debug: imprimir parámetros recibidos
        System.out.println("Correo recibido: " + correo);
        System.out.println("Contraseña recibida: " + contraseña);

        // Validación básica
        if (correo == null || correo.trim().isEmpty() || contraseña == null || contraseña.trim().isEmpty()) {
            request.setAttribute("error", "Correo y contraseña son obligatorios.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE correo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String passBD = rs.getString("contraseña");
                if (passBD.equals(contraseña)) { // En producción, usa BCrypt o similar
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", correo);
                    response.sendRedirect("rutina.jsp");
                } else {
                    request.setAttribute("error", "Contraseña incorrecta.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Correo no registrado.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error en el sistema. Por favor intente más tarde.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}