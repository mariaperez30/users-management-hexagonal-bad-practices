package com.jcaa.usersmanagement.domain.valueobject;

import static org.junit.jupiter.api.Assertions.*;

import com.jcaa.usersmanagement.domain.exception.InvalidUserNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests para {@link UserName}.
 * 
 * <p>Cubre: normalización de nombres, validación de nulos/vacíos y longitud mínima.
 */
@DisplayName("UserName Value Object Tests")
class UserNameTest {

  @ParameterizedTest
  @ValueSource(strings = {"John Arrieta", "   John Arrieta   ", "John Arrieta \t"})
  @DisplayName("Debería normalizar y crear un nombre de usuario válido")
  void shouldValidateUserNameMinimumLength(final String userName) {
    // Arrange
    final String correctUserName = "John Arrieta";

    // Act
    final UserName userNameVo = new UserName(userName);

    // Assert
    assertEquals(correctUserName, userNameVo.toString(), "El nombre no fue normalizado correctamente");
  }

  @Test
  @DisplayName("Debería lanzar NullPointerException cuando el nombre es nulo")
  void shouldValidateUserNameIsNotNull() {
    // Arrange & Act & Assert
    assertThrows(NullPointerException.class, () -> new UserName(null));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {"", "  ", "\t", "\n", "\r", "\f", "\b", "Jo", "Ty  ", "", "   Cy ", "Ed\t"})
  @DisplayName("Debería lanzar InvalidUserNameException cuando el nombre es vacío o inferior a 3 caracteres")
  void shouldValidateUserNameIsNotEmptyAndMinimumLength(final String userName) {
    // Arrange & Act & Assert
    assertThrows(InvalidUserNameException.class, () -> new UserName(userName));
  }
}
