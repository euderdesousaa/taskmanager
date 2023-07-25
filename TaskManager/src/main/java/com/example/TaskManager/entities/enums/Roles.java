package com.example.TaskManager.entities.enums;

public enum Roles {
    OWNER("owner"),
    USER("user");

    private final String role;

    Roles(String roles) {
        this.role = roles;
    }

    public String getRole() {
        return role;
    }

    public static Roles getRoleEnum(String roleString) {
        return switch (roleString.toLowerCase()) {
            case "owner" -> Roles.OWNER;
            case "user" -> Roles.USER;
            default -> throw new IllegalArgumentException("Role [" + roleString
                    + "] not supported.");
        };
    }
}
