<%@ page import="Modelo.Usuario" %>
<%@ page import="Modelo.IRutina" %>
<%@ page import="Modelo.IMaquina" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    IRutina rutina = (IRutina) session.getAttribute("rutina");

    if (usuario == null || rutina == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Rutina Personalizada - Gimnasio</title>
    <link rel="stylesheet" href="rutina.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
    <header class="header">
        <div class="container">
            <h1>Tu Rutina Personalizada</h1>
            <p class="subtitle">¡Vamos a ponernos en forma, <%= usuario.getNombre() %>!</p>
        </div>
    </header>

    <main class="container">
        <section class="usuario-info">
            <h2>Datos del Usuario</h2>
            <ul>
                <li><strong>Edad:</strong> <%= usuario.getEdad() %> años</li>
                <li><strong>Sexo:</strong> <%= usuario.getSexo() %></li>
                <li><strong>Peso:</strong> <%= Math.round(usuario.getPeso()) %> kg</li>
                <li><strong>Altura:</strong> <%= Math.round(usuario.getAltura()) %> cm</li>
                <li><strong>Objetivo:</strong> <%= usuario.getObjetivo() %></li>
            </ul>
        </section>

        <section class="rutina-ejercicios">
            <h2>Rutina con Pesos Personalizados</h2>
            <ul>
                <%
                    Map<IMaquina, Double> ejercicios = rutina.getEjerciciosConPeso();
                    for (Map.Entry<IMaquina, Double> entry : ejercicios.entrySet()) {
                        IMaquina maquina = entry.getKey();
                        Double peso = entry.getValue();
                %>
                    <li>
                        <span class="ejercicio-nombre"><%= maquina.getNombre() %></span>
                        <%
                            if (peso != null && peso > 0) {
                                out.print(": " + String.format("%.0fkg", peso));
                            }
                        %>
                    </li>
                <%
                    }
                %>
            </ul>
        </section>

        <section class="plan-semanal">
            <h2>Planificación Semanal</h2>
            <ul>
                <%
                    List<String> planSemanal = rutina.getPlanSemanal();
                    for (int i = 0; i < planSemanal.size(); i++) {
                        String dia = planSemanal.get(i);
                %>
                    <li><%= dia %></li>
                <%
                    }
                %>
            </ul>
        </section>

        <section class="alimentacion">
            <h2>Recomendación de Alimentación</h2>
            <p><%= rutina.getAlimentacion() %></p>
        </section>
    </main>

    <footer class="footer">
        <p>© 2025 Gimnasio SmartFit - Todos los derechos reservados</p>
    </footer>
</body>
</html>
