/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;
import java.util.Random;

/**
 *
 * @author ngoqu
 */
public class Helper {

    public static String checkPassword(
            String oldPassword,
            String correctPassword,
            String newPassword,
            String confirmPassword,
            int minLength,
            int maxLength
    ) {
        String errors = "";

        if (!oldPassword.equals(correctPassword)) {
            errors += "Current password is not correct! <br/>";
        }

        if (newPassword.isEmpty()) {
            errors += "New password should not be empty! <br/>";
        }

        if (!newPassword.equals(confirmPassword)) {
            errors += "New password must match with confirm password <br/>";
        }

        if (newPassword.length() < minLength || newPassword.length() > maxLength) {
            errors += "Password must be greater than " + minLength + " and less"
                    + "than " + maxLength + " characters <br/>";
        }

        return errors;
    }

    public static boolean checkRangeString(String input, String inputName, int min, int max, String[] error) {
        if (input.length() < min || input.length() > max) {
            return false;
        }
        return true;
    }

    public String checkPatternString(String input, String REGEX) {
        return null;
    }

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static final Random random = new Random();

    public static String generateRandomPassword(int passwordLength) {
        StringBuilder password = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(PASSWORD_ALLOW_BASE.length());
            password.append(PASSWORD_ALLOW_BASE.charAt(randomIndex));
        }

        return password.toString();
    }
    
    public static void checkLengthString(String inputName, int min, int max, List<String> listError, String... inputs) {
        for (String input : inputs) {
            if (input == null || input.length() < min || input.length() > max) {
                listError.add(inputName + " must be between " + min + " and " + max + " characters");

            }
        }

    }

    public static void checkPatternString(String inputName, String REGEX, List<String> listError, String... inputs) {
        for (String input : inputs) {
            if (!input.matches(REGEX)) {
                listError.add(inputName + " must be right form.");
            }
        }
    }
}
