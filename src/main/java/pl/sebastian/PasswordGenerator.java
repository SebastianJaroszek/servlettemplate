package pl.sebastian;

import java.util.Random;

public class PasswordGenerator {

    private static final String SYMBOLS = "!@#$%^&*()_=+-.,;'[]/?|";
    private static final String NUMBERS = "1234567890";
    private static final String UPPERCASE_CHARACTERS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String LOWERCASE_CHARACTERS = "qwertyuiopasdfghjklzxcvbnm";
    private static final String EMPTY = "";

    public static String generatePassword(Integer length, boolean symbols, boolean numbers, boolean lowercase, boolean uppercase) {

        String alphabet = EMPTY;
        if (symbols){
            alphabet += SYMBOLS;
        }
        if (numbers) {
            alphabet += NUMBERS;
        }
        if (lowercase) {
            alphabet += LOWERCASE_CHARACTERS;
        }
        if (uppercase) {
            alphabet += UPPERCASE_CHARACTERS;
        }
        if (alphabet.equals(EMPTY)){
            alphabet = LOWERCASE_CHARACTERS;
        }

        StringBuilder result = new StringBuilder();
        Random random = new Random();
        int alphabetLength = alphabet.length();
        for (int i = 0; i < length; i++) {
            int item = random.nextInt(alphabetLength);
            result.append(alphabet.charAt(item));
        }

        return result.toString();
    }
}
