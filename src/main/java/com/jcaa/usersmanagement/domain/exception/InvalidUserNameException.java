package com.jcaa.usersmanagement.domain.exception;

public final class InvalidUserNameException extends DomainException {

  private InvalidUserNameException(final String message) {
    super(message);
  }

  private static final String EMPTY_USER_NAME_MSG = "The user name must not be empty.";
  private static final String NAME_TOO_SHORT_TEMPLATE = "The user name must have at least %d characters.";

  public static InvalidUserNameException becauseValueIsEmpty() {
    return new InvalidUserNameException(EMPTY_USER_NAME_MSG);
  }

  public static InvalidUserNameException becauseLengthIsTooShort(final int minimumLength) {
    return new InvalidUserNameException(
        String.format(NAME_TOO_SHORT_TEMPLATE, minimumLength));
  }
}
