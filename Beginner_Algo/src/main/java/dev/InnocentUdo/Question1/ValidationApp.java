package dev.InnocentUdo.Question1;

import dev.InnocentUdo.Models.JwtTokenizationGen;
import dev.InnocentUdo.Models.StaticVar;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your Date of Birth (YYYY-MM-DD): ");
        String dobStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dobStr);

        // Validate user inputs and generate response
        String response = validateUserInputs(username, password, email, dateOfBirth);
        System.out.println(response);

        // Testing token verification method
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZGV0dEBnbWFpbC5jb20iLCJpYXQiOjE2OTI2Mjc3OTcsImV4cCI6MTY5MjcxNDE5N30.FpT7FeYhs8-tUgYU4TDGmpsapXmEhI19zVIho6_dQns";
        String verificationStatus = verifyToken(token);
        System.out.println("Token Verification: " + verificationStatus);
    }

    public static String validateUserInputs(String username, String password, String email, LocalDate dateOfBirth) {
        String emptyFieldMessage = checkEmptyFields(username, password, email, dateOfBirth);
        if (emptyFieldMessage != null) {
            return emptyFieldMessage;
        }

        if (!isStrongPassword(password) || !hasUpperCase(password) || !hasDigits(password) || !hasLetters(password)) {
            return StaticVar.WEAK_PASSWORD + "\n" + StaticVar.FALSE_STATUS_MESSAGE;
        }

        if (password.length() < 8) {
            return StaticVar.PASSWORD_MINIMUM_CHARACTER_MESSAGE + "\n" + StaticVar.FALSE_STATUS_MESSAGE;
        }

        if (!isValidAge(dateOfBirth)) {
            return StaticVar.MINIMUM_AGE_MESSAGE + "\n" + StaticVar.FALSE_STATUS_MESSAGE;
        }

        if (username.length() < 4) {
            return StaticVar.MINIMUM_CHARACTER_MESSAGE + "\n" + StaticVar.FALSE_STATUS_MESSAGE;
        }

        if (isInvalidEmailPattern(email, StaticVar.REGEX_PATTERN)) {
            return StaticVar.WRONG_EMAIL_MESSAGE;
        }

        return StaticVar.SUCCESS_MESSAGE + "\n" + StaticVar.TRUE_STATUS_MESSAGE +
                "\nToken: " + JwtTokenizationGen.generateToken(email);
    }

    public static String verifyToken(String token) {
        String tokenStatus = JwtTokenizationGen.validateToken(token);
        return tokenStatus.equals(StaticVar.VERIFICATION_PASS_MESSAGE)
                ? StaticVar.VERIFICATION_PASS_MESSAGE
                : StaticVar.VERIFICATION_FAILS_MESSAGE;
    }

    private static String checkEmptyFields(String username, String password, String email, LocalDate dateOfBirth) {
        if (username.isBlank()) {
            return StaticVar.USERNAME_NOT_NULL_MESSAGE;
        }
        if (password.isBlank()) {
            return StaticVar.PASSWORD_NOT_NULL_MESSAGE;
        }
        if (email.isBlank()) {
            return StaticVar.EMAIL_NOT_NULL_MESSAGE;
        }
        if (dateOfBirth == null) {
            return StaticVar.DATE_OF_BIRTH_NOT_NULL_MESSAGE;
        }
        return null;
    }

    private static boolean isStrongPassword(String password) {
        return !Pattern.compile("[!@#$%^&*]").matcher(password).find();
    }

    private static boolean hasUpperCase(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    private static boolean hasLetters(String password) {
        return password.chars().anyMatch(Character::isLetter);
    }

    private static boolean hasDigits(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }

    private static boolean isValidAge(LocalDate date) {
        return date.isBefore(LocalDate.now().minusYears(16));
    }

    private static boolean isInvalidEmailPattern(String emailAddress, String regexPattern) {
        return !Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }
}

