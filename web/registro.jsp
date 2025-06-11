<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro de Usuario</title>
</head>
<body>
    <h1>Registro de Nuevo Usuario</h1>
    
    <% if (request.getAttribute("error") != null) { %>
        <div style="color: red;"><%= request.getAttribute("error") %></div>
    <% } %>
    
    <form action="${pageContext.request.contextPath}/RegistroServlet" method="POST">
        <div>
            <label>Nombre:</label>
            <input type="text" name="nombre" required>
        </div>
        
        <div>
            <label>Edad:</label>
            <input type="number" name="edad" required>
        </div>
        
        <div>
            <label>Sexo:</label>
            <select name="sexo" required>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
                <option value="Otro">Otro</option>
            </select>
        </div>
        
        <div>
            <label>Altura (cm):</label>
            <input type="number" step="0.01" name="altura" required>
        </div>
        
        <div>
            <label>Peso (kg):</label>
            <input type="number" step="0.01" name="peso" required>
        </div>
        
        <div>
            <label>Objetivo:</label>
            <select name="objetivo" required>
                <option value="Bajar de peso">Bajar de peso</option>
                <option value="Ganar masa muscular">Ganar masa muscular</option>
                <option value="Definir">Definir</option>
                <option value="Mejorar resistencia">Mejorar resistencia</option>
            </select>
        </div>
        
        <div>
            <label>Correo electrónico:</label>
            <input type="email" name="correo" required>
        </div>
        
        <div>
            <label>Contraseña:</label>
            <input type="password" name="contraseña" required>
        </div>
        
        <button type="submit">Registrarse</button>
    </form>
</body>
</html>