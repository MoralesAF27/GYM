<%@page import="Modelo.Usuario, Modelo.IRutina, Modelo.IMaquina, java.util.Map, java.util.List" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    IRutina rutina = (IRutina) session.getAttribute("rutina");
    
    if (usuario == null || rutina == null) {
        response.sendRedirect(request.getContextPath() + "/registro.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tu Rutina Personalizada</title>
    <style>
        .container { max-width: 800px; margin: 0 auto; }
        .section { margin-bottom: 30px; }
        .ejercicio { margin: 10px 0; padding: 10px; background: #f5f5f5; }
    </style>
</head>
<body>
    <div class="container">
        <h1>¡Bienvenido <%= usuario.getNombre() %>!</h1>
        
        <div class="section">
            <h2>Tu Información</h2>
            <p><strong>Objetivo:</strong> <%= usuario.getObjetivo() %></p>
            <p><strong>Peso:</strong> <%= usuario.getPeso() %> kg</p>
            <p><strong>Altura:</strong> <%= usuario.getAltura() %> cm</p>
        </div>
        
        <div class="section">
            <h2>Plan de Alimentación</h2>
            <p><%= rutina.getAlimentacion() %></p>
        </div>
        
        <div class="section">
            <h2>Plan Semanal</h2>
            <ul>
                <% for (String dia : rutina.getPlanSemanal()) { %>
                    <li><%= dia %></li>
                <% } %>
            </ul>
        </div>
        
        <div class="section">
            <h2>Ejercicios Recomendados</h2>
            <% for (Map.Entry<IMaquina, Double> ejercicio : rutina.getEjerciciosConPeso().entrySet()) { %>
                <div class="ejercicio">
                    <h3><%= ejercicio.getKey().getNombre() %></h3>
                    <p>Peso recomendado: <%= String.format("%.1f kg", ejercicio.getValue()) %></p>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>