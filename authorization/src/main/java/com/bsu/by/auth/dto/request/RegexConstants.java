package com.bsu.by.auth.dto.request;

public class RegexConstants {
    private RegexConstants() {}
    public static final String EMAIL_REGEX = "[\\p{Upper}\\p{Lower}\\p{Digit}]+@" +
            "[\\p{Upper}\\p{Lower}\\p{Digit}]+\\.[\\p{Upper}\\p{Lower}\\p{Digit}]+";
    public static final String PASSWORD_REGEX = "((?=.*\\p{Upper})(?=.*\\p{Lower})(?=.*\\p{Digit})(?=.*[ \\p{Punct}]))" +
            "[\\p{Upper}\\p{Lower}\\p{Digit} \\p{Punct}]{6,32}";
}
