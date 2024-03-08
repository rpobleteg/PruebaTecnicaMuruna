
package com.example.prueba.tecnica.service.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import com.example.prueba.tecnica.service.UserDataValidationService;


public class UserDataValidationServiceUnitTest {
	
	@InjectMocks
    private UserDataValidationService userDataValidationService;

	@Test
	public void testUserValidation_ValidEmail() {
		
	    String validEmail = "juan@rodriguez.org";

        assertDoesNotThrow(() -> userDataValidationService.validateEmail(validEmail));
	}

    @Test
    public void testUserValidation_InvalidEmail() {
    	
        String invalidEmail = "invalid-email";

        assertThrows(RuntimeException.class, () -> userDataValidationService.validateEmail(invalidEmail));
    } 
    
}
