package com.example.prueba.tecnica.service;

public class UserDataValidationService {
	
	public void validatePassword(String password) {
        String regex = "^.{4,}$";
        if (!password.matches(regex)) {
            throw new RuntimeException("El formato de la contraseña es inválido");
        }
	}
	
	public void validateEmail(String email) {
		String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		if (!email.matches(regex)) {
            throw new RuntimeException("El formato del correo es inválido");
        }

	}

}
