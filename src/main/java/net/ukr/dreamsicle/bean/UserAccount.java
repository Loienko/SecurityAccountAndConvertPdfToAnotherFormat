package net.ukr.dreamsicle.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserAccount {
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";

    private String userName;
    private String gender;
    private String password;

    private List<String> roles;

    public UserAccount(String userName, String password, String gender, String... roles) {
        this.userName = userName;
        this.gender = gender;
        this.password = password;

        this.roles = new ArrayList<>();
        if (roles != null) {
            for (String role : roles) {
                this.roles.add(role);
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(password, that.password) &&
                Objects.equals(roles, that.roles);

    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, gender, password, roles);
    }
}
