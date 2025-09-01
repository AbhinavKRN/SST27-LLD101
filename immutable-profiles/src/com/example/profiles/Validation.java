package com.example.profiles;

import java.util.Objects;

public final class Validation {
    private Validation() {}

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static void requireNonBlank(String val, String fieldName) {
        if (isBlank(val)) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
    }

    public static void requireEmail(String email) {
        Objects.requireNonNull(email, "Email cannot be null");
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
        if (email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
    }

    public static void requireValidId(String id) {
        requireNonBlank(id, "ID");
        if (id.length() < 2) {
            throw new IllegalArgumentException("ID must be at least 2 characters long");
        }
        if (id.length() > 50) {
            throw new IllegalArgumentException("ID cannot exceed 50 characters");
        }
    }

    public static void validateDisplayName(String displayName) {
        if (displayName != null && displayName.length() > 100) {
            throw new IllegalArgumentException("Display name cannot exceed 100 characters");
        }
    }

    public static void validatePhone(String phone) {
        if (phone != null && !phone.matches("^[\\d\\s\\-\\(\\)\\+]+$")) {
            throw new IllegalArgumentException("Phone number contains invalid characters: " + phone);
        }
    }

    public static void validateTwitterHandle(String twitter) {
        if (twitter != null && !twitter.startsWith("@")) {
            throw new IllegalArgumentException("Twitter handle must start with @: " + twitter);
        }
        if (twitter != null && twitter.contains(" ")) {
            throw new IllegalArgumentException("Twitter handle cannot contain spaces: " + twitter);
        }
    }

    public static void validateGithubUsername(String github) {
        if (github != null && !github.matches("^[a-zA-Z0-9\\-]+$")) {
            throw new IllegalArgumentException("GitHub username can only contain letters, numbers, and hyphens: " + github);
        }
    }
}
