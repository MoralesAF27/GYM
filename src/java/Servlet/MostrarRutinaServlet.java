package Servlet;

import Control.UsuarioDAO;
import Modelo.IRutina;
import Modelo.RutinaFactory;
import Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/MostrarRutinaServlet")
public class MostrarRutinaServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener sesión existente sin crear una nueva
        HttpSession session = request.getSession(false);
        String correoUsuario = null;
        if (session != null) {
            correoUsuario = (String) session.getAttribute("correo");
        }

        // Si no hay correo en sesión, redirigir a login
        if (correoUsuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            // Obtener usuario desde base de datos
            Usuario usuario = usuarioDAO.obtenerUsuarioPorCorreo(correoUsuario);
            if (usuario == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            // Crear rutina según el usuario
            RutinaFactory rutinaFactory = new RutinaFactory();
            IRutina rutina = rutinaFactory.crearRutina(usuario);

            // Pasar usuario y rutina a JSP
            request.setAttribute("usuario", usuario);
            request.setAttribute("rutina", rutina);

            // Forward a rutina.jsp para mostrar la rutina personalizada
            request.getRequestDispatcher("rutina.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
