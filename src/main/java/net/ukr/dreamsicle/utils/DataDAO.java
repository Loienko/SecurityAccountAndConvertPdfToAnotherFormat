package net.ukr.dreamsicle.utils;

import net.ukr.dreamsicle.bean.UserAccount;
import net.ukr.dreamsicle.config.SecurityConfig;

import java.util.HashMap;
import java.util.Map;

public class DataDAO {
    private static final Map<String, UserAccount> mapUsers = new HashMap<>();

    static {
        initUsers();
    }

    private static void initUsers() {

        // This user has a role as EMPLOYEE.
        UserAccount user = new UserAccount("user", "123", UserAccount.GENDER_MALE, SecurityConfig.ROLE_ADMIN);

        // This user has 2 roles EMPLOYEE and MANAGER.
        UserAccount admin = new UserAccount("admin", "321", UserAccount.GENDER_MALE, SecurityConfig.ROLE_ADMIN, SecurityConfig.ROLE_USER);

        mapUsers.put(user.getUserName(), user);
        mapUsers.put(admin.getUserName(), admin);
    }

    // Find a User by userName and password.
    public static UserAccount findUser(String userName, String password) {
        UserAccount u = mapUsers.get(userName);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
}
