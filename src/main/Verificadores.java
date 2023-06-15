package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificadores {
    // Esse verificador faz a verificação se o valor é um número
    public static boolean isNumeric(String input){
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean validaEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+).(.[a-z]{2,3})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
