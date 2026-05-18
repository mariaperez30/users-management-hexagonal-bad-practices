package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io;

import java.io.PrintStream;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ConsoleIO {

  private static final String ERROR_BLANK_VALUE = "  Value cannot be blank. Please try again.";
  private static final String ERROR_INVALID_NUMBER = "  Invalid input. Please enter a number.";

  private final Scanner scanner;
  private final PrintStream out;

  public String readRequired(final String prompt) {
    String input;
    do {
      out.print(prompt);
      input = scanner.nextLine().trim();
      if (input.isBlank()) {
        out.println(ERROR_BLANK_VALUE);
      }
    } while (input.isBlank());
    return input;
  }

  public String readOptional(final String prompt) {
    out.print(prompt);
    return scanner.nextLine().trim();
  }

  public int readInt(final String prompt) {
    while (true) {
      out.print(prompt);
      final String input = scanner.nextLine().trim();
      try {
        return Integer.parseInt(input);
      } catch (final NumberFormatException ignored) {
        out.println(ERROR_INVALID_NUMBER);
      }
    }
  }

  public void println(final String message) { out.println(message); }
  public void println() { out.println(); }
  public void printf(final String format, final Object... args) { out.printf(format, args); }
}