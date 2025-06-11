function validarLogin() {
    const correo = document.getElementById('correo').value.trim();
    const contraseña = document.getElementById('contraseña').value.trim();

    // Validación básica
    if (!correo) {
        alert('Por favor ingresa tu correo electrónico');
        return false;
    }

    if (!contraseña) {
        alert('Por favor ingresa el campo de texto'); // Changed message
        return false;
    }

    // Validación de formato de correo simple
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(correo)) {
        alert('Por favor ingresa un correo electrónico válido');
        return false;
    }

    // Removed: No longer checking password length
    // if (contraseña.length < 6) {
    //     alert('La contraseña debe tener al menos 6 caracteres');
    //     return false;
    // }

    return true;
}

// Validación en tiempo real
document.getElementById('correo').addEventListener('input', function() {
    this.style.borderColor = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.value.trim())
        ? '#4CAF50'
        : '#ffb703';
});

document.getElementById('contraseña').addEventListener('input', function() {
    // Simplified validation for a normal text field
    this.style.borderColor = this.value.trim().length > 0
        ? '#4CAF50'
        : '#ffb703';
});

// Removed: Show/hide password functionality
/*
document.querySelectorAll('.password-toggle').forEach(toggle => {
    toggle.addEventListener('click', function() {
        const passwordInput = this.previousElementSibling;
        const isPassword = passwordInput.type === 'password';
        
        passwordInput.type = isPassword ? 'text' : 'password';
        this.textContent = isPassword ? '🙈' : '👁️';
        this.setAttribute('aria-label', isPassword ? 'Ocultar contraseña' : 'Mostrar contraseña');
    });
});
*/