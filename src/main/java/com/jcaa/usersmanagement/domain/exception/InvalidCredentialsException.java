package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCredentialsException extends DomainException {

  private InvalidCredentialsException(final String message) {
    super(message);
  }

  private static final String INVALID_CREDENTIALS_MSG = "Correo o contraseña incorrectos.";
  private static final String INACTIVE_USER_MSG = "Tu cuenta no está activa. Contacta al administrador.";

  public static InvalidCredentialsException becauseCredentialsAreInvalid() {
    return new InvalidCredentialsException(INVALID_CREDENTIALS_MSG);
  }

  public static InvalidCredentialsException becauseUserIsNotActive() {
    return new InvalidCredentialsException(INACTIVE_USER_MSG);
  }
}
