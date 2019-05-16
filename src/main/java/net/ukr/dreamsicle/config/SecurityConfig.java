package net.ukr.dreamsicle.config;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {

        // Конфигурация для роли "EMPLOYEE".
        List<String> urlUser = new ArrayList<>();

        urlUser.add("/userInfo");
        urlUser.add("/employeeTask");

        mapConfig.put(ROLE_ADMIN, urlUser);

        // Конфигурация для роли "MANAGER".
        List<String> urlAdmin = new ArrayList<>();

        urlAdmin.add("/userInfo");
        urlAdmin.add("/managerTask");

        mapConfig.put(ROLE_USER, urlAdmin);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
