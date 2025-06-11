<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Inicio de Sesión - Gimnasio</title>
    <link rel="stylesheet" href="formulario.css" />
    <script src="validaciones_login.js" defer></script> <%-- Added 'defer' to ensure script runs after HTML is parsed --%>
</head>
<body>
    <div class="container">
        <header>
            <img src="img/gimnasio.jpg" alt="Gimnasio" class="banner" />
            <h1>Iniciar Sesión</h1>
        </header>

        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <div class="error-message"><%= error %></div>
        <% } %>

        <form action="LoginServlet" method="post">
            <fieldset>
                <legend>Acceso de Usuario</legend>

                <label for="correo">Correo electrónico:</label>
                <input type="text" id="correo" name="correo" placeholder="usuario@ejemplo.com" />

                <label for="contraseña">Contraseña:</label>
                <input type="text" id="contraseña" name="contraseña" placeholder="********" />
            </fieldset>

            <div class="boton-enviar">
                <button type="submit">Ingresar</button>
            </div>
        </form>

        <%-- Inline styles and event handlers for the "Registrarse" button --%>
        <div style="text-align: center; margin-top: 20px; color: #ffd966;">
            <p>¿No tienes cuenta?</p>
            <button onclick="window.location.href='registro.jsp'"
                style="
                    background-color: transparent;
                    border: 2px solid #ffb703;
                    color: #ffb703;
                    padding: 10px 25px;
                    border-radius: 12px;
                    font-weight: 700;
                    cursor: pointer;
                    transition: all 0.3s ease;
                "
                onmouseover="this.style.backgroundColor='#ffb703'; this.style.color='#1e3c72';"
                onmouseout="this.style.backgroundColor='transparent'; this.style.color='#ffb703';"
            >Registrarse</button>
        </div>
    </div>
</body>
</html>