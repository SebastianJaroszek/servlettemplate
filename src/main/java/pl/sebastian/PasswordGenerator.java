package pl.sebastian;

import java.util.ArrayList;
import java.util.List;
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

        String result = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int item = random.nextInt(alphabet.length());
            result += alphabet.charAt(item);
        }

        return result;
    }
}
