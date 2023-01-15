package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatePassword() {
        // 8글자
        return "abcdefgh";
    }
}
