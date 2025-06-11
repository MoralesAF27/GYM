package servlet;

import Control.RutinaDAO;
import Control.UsuarioDAO;
import Modelo.IRutina;
import Modelo.Rutina;
import Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final RutinaDAO rutinaDAO = new RutinaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("RegistroServlet: doPost ejecutándose"); // Log de depuración
        
        try {
            // 1. Obtener parámetros del formulario
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            double altura = Double.parseDouble(request.getParameter("altura"));
            double peso = Double.parseDouble(request.getParameter("peso"));
            String objetivo = request.getParameter("objetivo");
            String correo = request.getParameter("correo");
            String contraseña = request.getParameter("contraseña");

            // 2. Crear objeto Usuario
            Usuario usuario = new Usuario(nombre, edad, sexo, altura, peso, objetivo);
            
            // 3. Registrar usuario en BD
            int usuarioId = usuarioDAO.insertarUsuario(usuario, correo, contraseña);
            
            // 4. Obtener rutina correspondiente
            IRutina rutina = rutinaDAO.obtenerRutinaPorNombre(objetivo);
            if (rutina == null) {
                throw new Exception("No se encontró rutina para el objetivo: " + objetivo);
            }
            
            // 5. Calcular pesos personalizados
            if (rutina instanceof Rutina) {
                ((Rutina) rutina).calcularPesosParaUsuario(peso);
            }
            
            // 6. Asignar rutina al usuario
            usuarioDAO.asignarRutinaUsuario(usuarioId, obtenerIdRutinaPorNombre(objetivo));
            
            // 7. Establecer atributos en sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            session.setAttribute("rutina", rutina);
            
            // 8. Redirigir a página de rutina
            response.sendRedirect(request.getContextPath() + "/rutina.jsp");
            
        } catch (NumberFormatException e) {
            manejarError(request, response, "Error en formato numérico: " + e.getMessage());
        } catch (SQLException e) {
            manejarError(request, response, "Error de base de datos: " + e.getMessage());
        } catch (Exception e) {
            manejarError(request, response, "Error: " + e.getMessage());
        }
    }

    private int obtenerIdRutinaPorNombre(String nombre) throws SQLException {
        String sql = "SELECT id FROM rutinas WHERE nombre = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
                throw new SQLException("Rutina no encontrada");
            }
        }
    }

    private void manejarError(HttpServletRequest request, HttpServletResponse response, String mensaje) 
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
    }
}