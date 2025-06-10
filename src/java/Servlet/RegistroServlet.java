package Servlet;

import Modelo.Usuario;
import Modelo.IRutinaFactory;
import Modelo.IRutina;
import Modelo.RutinaFactory;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    private IRutinaFactory rutinaFactory;

    @Override
    public void init() {
        rutinaFactory = new RutinaFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double altura = Double.parseDouble(request.getParameter("altura"));
        double peso = Double.parseDouble(request.getParameter("peso"));
        String objetivo = request.getParameter("objetivo");

        Usuario usuario = new Usuario(nombre, edad, sexo, altura, peso, objetivo);

        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);

        IRutina rutina = rutinaFactory.crearRutina(usuario);
        session.setAttribute("rutina", rutina);

        response.sendRedirect("rutina.jsp");
    }
}
