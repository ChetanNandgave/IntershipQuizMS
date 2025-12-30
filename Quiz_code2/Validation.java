package com.app.util;

import java.util.regex.Pattern;

public class Validation {
    private static final Pattern EMAIL =
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean validName(String s) {
        return s != null && s.length() >= 2;
    }

    public static boolean validEmail(String s) {
        return EMAIL.matcher(s).matches();
    }

    public static boolean validPassword(String s) {
        return s != null && s.length() >= 6;
    }
}
