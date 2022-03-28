package uz.pdp.dao.user;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.models.user.User;

import java.util.ArrayList;

public class UserDao {
    private static ArrayList<User> users = new ArrayList<>();
    private static  User sessionUser = null;

    public static void addUser(User user) {
        users.add(user);
    }
    public static void setSession(User user) {
        sessionUser = user;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static  User getSessionUser() {
        return sessionUser;
    }

    public static void addMoney(double money) {
        sessionUser.setBalance(sessionUser.getBalance() + money);
    }
}
