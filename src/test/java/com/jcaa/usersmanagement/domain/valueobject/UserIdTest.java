package com.jcaa.usersmanagement.domain.valueobject;

import static org.junit.jupiter.api.Assertions.*;

import com.jcaa.usersmanagement.domain.exception.InvalidUserIdException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests para {@link UserId}.
 * 
 * <p>Cubre: normalización de ID, validación de nulos y vacíos.
 */
@DisplayName("UserId Value Object Tests")
class UserIdTest {

  @ParameterizedTest
  @ValueSource(strings = {" user123 ", "  user123  ", "user123\t"})
  @DisplayName("Debería crear un UserId normalizado eliminando espacios")
  void shouldCreateUserIdWithTrimmedValue(String input) {
    // Arrange
    final String correctUserId = "user123";

    // Act
    final UserId userId = new UserId(input);

    // Assert
    assertEquals(correctUserId, userId.toString(), "El ID de usuario no fue normalizado correctamente");
  }

  @Test
  @DisplayName("Debería lanzar NullPointerException cuando el ID es nulo")
  void shouldThrowNullPointerExceptionWhenUserIdIsNull() {
    // Arrange & Act & Assert
    assertThrows(NullPointerException.class, () -> new UserId(null));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "   ", "\t", "\n", "\r", "\f", "\b"})
  @DisplayName("Debería lanzar InvalidUserIdException cuando el ID es vacío")
  void shouldThrowIllegalArgumentExceptionWhenUserIdIsEmpty(String input) {
    // Arrange & Act & Assert
    assertThrows(InvalidUserIdException.class, () -> new UserId(input));
  }
}
