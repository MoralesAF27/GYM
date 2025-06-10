function validarFormulario() {
    var nombre = document.getElementById("nombre").value.trim();
    var edad = document.getElementById("edad").value.trim();
    var sexo = document.getElementById("sexo").value;
    var altura = document.getElementById("altura").value.trim();
    var peso = document.getElementById("peso").value.trim();
    var objetivos = document.getElementsByName("objetivo");

    if (nombre === "") {
        alert("Por favor ingrese su nombre completo.");
        return false;
    }

    if (edad === "" || isNaN(edad) || parseInt(edad) <= 0) {
        alert("Por favor ingrese una edad válida.");
        return false;
    }

    if (sexo === "") {
        alert("Por favor seleccione su sexo.");
        return false;
    }

    if (altura === "" || isNaN(altura) || parseInt(altura) <= 0) {
        alert("Por favor ingrese una altura válida en cm.");
        return false;
    }

    if (peso === "" || isNaN(peso) || parseInt(peso) <= 0) {
        alert("Por favor ingrese un peso válido en kg.");
        return false;
    }

    var objetivoSeleccionado = false;
    for (var i = 0; i < objetivos.length; i++) {
        if (objetivos[i].checked) {
            objetivoSeleccionado = true;
            break;
        }
    }

    if (!objetivoSeleccionado) {
        alert("Por favor seleccione un objetivo.");
        return false;
    }

    return true;
}
