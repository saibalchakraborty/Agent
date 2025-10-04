package com.demo.agent.util;

public class PIIMaskingUtil {
    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) return email;
        String[] parts = email.split("@", 2);
        String username = parts[0];
        String domain = parts[1];
        if (username.length() <= 2) {
            return username.charAt(0) + "***@" + domain;
        }
        StringBuilder masked = new StringBuilder();
        masked.append(username.charAt(0));
        for (int i = 1; i < username.length() - 1; i++) {
            masked.append("*");
        }
        masked.append(username.charAt(username.length() - 1));
        return masked + "@" + domain;
    }

    public static String maskPhone(String phone) {
        if (phone == null || phone.length() < 4) return phone;
        int unmasked = 4;
        int maskedLen = phone.length() - unmasked;
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < maskedLen; i++) {
            masked.append("*");
        }
        masked.append(phone.substring(maskedLen));
        return masked.toString();
    }
}
